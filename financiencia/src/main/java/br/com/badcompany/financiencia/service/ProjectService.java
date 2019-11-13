package br.com.badcompany.financiencia.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.badcompany.financiencia.exception.GenericException;
import br.com.badcompany.financiencia.model.DateProjectEval;
import br.com.badcompany.financiencia.model.DateSendProject;
import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.model.enums.Eval;
import br.com.badcompany.financiencia.myutils.MessageStateProject;
import br.com.badcompany.financiencia.repository.DateProjectEvalRepository;
import br.com.badcompany.financiencia.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository pRepo;
	@Autowired
	private AccessorService aServ;
	@Autowired
	private DateProjectEvalRepository dtProjectEvalRepo;
	@Autowired
	private DateSendProjectService dtProjectSendServ;

	public boolean addProject(Project p) {
		Random rand = new Random();
		int accessorsSizeList = this.aServ.sizeAccessorsList();
		Accessor accessor = null;
		for (int i = 0; i < accessorsSizeList; i++) {
			accessor = this.aServ.findAccessorById((long) rand.nextInt(accessorsSizeList) + 1);
			if (accessor.getSpecialties().equals(p.getSpecialty())) {
				accessor.getProjects().add(p);
				this.pRepo.save(p);
				this.aServ.updateAccessor(accessor);
				this.dtProjectSendServ.addDateSendProject(p);
				return true;
			}
		}
		if (this.pRepo.save(p) != null) {
			return true;
		}
		return false;
	}

	public void evalProject(Long id, boolean isApproved) throws GenericException {
		if (isProjectExists(id) && !wasEvaluete(id) && wasSendded(id)) {
			DateProjectEval dtToPersist = new DateProjectEval();

			if (isApproved)
				dtToPersist.setApproved(Eval.APPROVED);
			else
				dtToPersist.setApproved(Eval.DISAPPROVED);

			dtToPersist.setValuationDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			dtToPersist.setProject(pRepo.findById(id).get());

			dtProjectEvalRepo.save(dtToPersist);
			this.aServ.deleteEvalProjects(pRepo.findById(id).get());
		} else {
			throw new GenericException("The project does not exist or has been evaluated !!");
		}
	}

	public List<Project> projectsList() {
		return this.pRepo.findAll();
	}

	public List<String> validateProject(Long id) {
		List<String> errs = new ArrayList<>();
		if (!isProjectExists(id))
			errs.add("project not registered");
		else {
//			não é possivel avaliar sem mandar
			if (!wasSendded(id))
				errs.add("project without evaluator.");
		}

		return errs;
	}

	public MessageStateProject stateOf(Long id) {
		DateProjectEval dtEval = this.dtProjectEvalRepo.findByProjectId(id);
		DateSendProject dtSend = this.dtProjectSendServ.getStatus(id);
		if (dtEval != null) {
			return dtEval.getApproved() == Eval.APPROVED
					? new MessageStateProject("Approved", dtEval.getValuationDate())
					: new MessageStateProject("Disapproved", dtEval.getValuationDate());
		}
		return new MessageStateProject("In analysis", dtSend.getDateSubmission());
	}

	public Project getOneProject(Long id) {
		return this.pRepo.getOne(id);
	}

	public Project getProjectByIntenalCode(String code) {
		return this.pRepo.findByInternalCode(code);
	}

	public boolean isProjectExists(Long id) {
		for (Project p : pRepo.findAll())
			if (p.getId() == id)
				return true;
		return false;
	}

	public boolean wasEvaluete(Long id) {
		return this.dtProjectEvalRepo.findByProjectId(id) != null ? true : false;
	}

	public boolean wasSendded(Long id) {
		return this.dtProjectSendServ.getStatus(id) != null ? true : false;
	}
}

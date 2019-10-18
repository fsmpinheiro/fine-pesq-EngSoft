package br.com.badcompany.financiencia.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.badcompany.financiencia.exception.GenericException;
import br.com.badcompany.financiencia.model.DateProjectEval;
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
	private DateProjectEvalRepository dtProjectEvalRepo;

	public void addProject(Project p) {
		this.pRepo.save(p);
	}

	public void evalProject(Long id, boolean isApproved) throws GenericException {
		if (isProjectExists(id) && !wasEvaluete(id)) {
			DateProjectEval dtToPersist = new DateProjectEval();

			if (isApproved)
				dtToPersist.setApproved(Eval.APPROVED);
			else
				dtToPersist.setApproved(Eval.DISAPPROVED);

			dtToPersist.setValuationDate(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
			dtToPersist.setProject(pRepo.findById(id).get());

			dtProjectEvalRepo.save(dtToPersist);
		} else {
			throw new GenericException("The project does not exist or has been evaluated !!");
		}
	}

	public List<Project> projectsList() {
		return this.pRepo.findAll();
	}

	public MessageStateProject stateOf(Long id) throws NoSuchElementException{
		DateProjectEval dt = this.dtProjectEvalRepo.findByProjectId(id);
		return dt.getApproved() == Eval.APPROVED
				? new MessageStateProject("Approved", dt.getValuationDate())
				: new MessageStateProject("Disapproved", dt.getValuationDate());
	}
	
	public Project getOneProject(Long id) {
		return this.pRepo.getOne(id);
	}

	private boolean isProjectExists(Long id) {
		return this.pRepo.findById(id) != null ? true : false;
	}
	
	private boolean wasEvaluete(Long id) {
		return this.dtProjectEvalRepo.findByProjectId(id) != null ? true : false;
	}
}

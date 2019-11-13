package br.com.badcompany.financiencia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.repository.AccessorRepository;

@Service
public class AccessorService {

	@Autowired
	private AccessorRepository aRepo;

	@Autowired
	private ProjectService pServ;

	@Autowired
	private DateSendProjectService dtProjectSendServ;

	public Accessor findAccessorById(Long id) {
		for (Accessor a : this.aRepo.findAll()) {
			if(a.getId() == id)
				return a;
		}
		return null;
	}

	public int sizeAccessorsList() {
		return this.aRepo.findAll().size();
	}
	
	public boolean accessorExistsById(Long id) {
		for (Accessor a : this.aRepo.findAll())
			if (a.getId() == id)
				return true;
		return false;
	}
	public Accessor updateAccessor(Accessor a) {
		return this.aRepo.save(a);
	}
	public Accessor addAccessor(Accessor a) {
		for (Accessor finded : aRepo.findAll()) {
			if (finded.getUsername().equals(a.getUsername()))
				return null;
		}
		a.setPassword(new BCryptPasswordEncoder().encode(a.getPassword()));
		return this.aRepo.save(a);
	}

	public List<Project> projectsToEvaluate(Long id) {
		Accessor a = this.aRepo.getOne(id);

		for (Project p : this.pServ.projectsList()) {
			if (!this.pServ.wasSendded(p.getId()) && !this.pServ.wasEvaluete(p.getId())
					&& p.getSpecialty().equals(a.getSpecialties())) {
				dtProjectSendServ.addDateSendProject(p);
				a.getProjects().add(p);
				this.aRepo.save(a);
			}
		}
		return a.getProjects();
	}
	public void deleteEvalProjects(Project p) {
		for (Accessor a : this.aRepo.findAll()) {
			a.getProjects().remove(p);
			updateAccessor(a);
		}
	}
}

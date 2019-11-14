package br.com.badcompany.financiencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.badcompany.financiencia.model.entities.Researcher;
import br.com.badcompany.financiencia.repository.ResearcherRepository;

@Service
public class ResearcherService {
	
	@Autowired
	private ResearcherRepository rRepo;
	
	@Autowired
	private ProjectService pServ;
	
	public boolean addResearcher(Researcher r) {
		if (r.getProjectsSubmited() != null) {
			pServ.addProject(r.getProjectsSubmited().get(0));
			r.setPassword(new BCryptPasswordEncoder().encode(r.getPassword()));
			this.rRepo.save(r);
			return true;
		}
		return false;
	}
}

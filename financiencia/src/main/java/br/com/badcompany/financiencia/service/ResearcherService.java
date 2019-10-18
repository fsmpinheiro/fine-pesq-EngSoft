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
	
	public void addResearcher(Researcher r) {
		r.setPassword(new BCryptPasswordEncoder().encode(r.getPassword()));
		this.rRepo.save(r);
	}
}

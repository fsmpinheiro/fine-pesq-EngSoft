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
	
	public void addAccessor(Accessor a) {
		a.setPassword(new BCryptPasswordEncoder().encode(a.getPassword()));
		this.aRepo.save(a);
	}
	
	public List<Project> projectsToEvaluate(Long id){
		return this.aRepo.getOne(id).getProjects();
	}
}

package br.com.badcompany.financiencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.badcompany.financiencia.model.Project;
import br.com.badcompany.financiencia.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository pRepo;
	
	public void addProject(Project p) {
		this.pRepo.save(p);
	}
}

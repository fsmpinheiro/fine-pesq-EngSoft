package br.com.badcompany.financiencia.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.badcompany.financiencia.model.DateSendProject;
import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.repository.DateProjectSendRepository;

@Service
public class DateSendProjectService {
	
	@Autowired
	private DateProjectSendRepository dtSendRepo;
	
	public void addDateSendProject(Project p) {
		DateSendProject dtSendProject = new DateSendProject();
		dtSendProject.setDateSubmission(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		dtSendProject.setProjectSubmited(p);
		this.dtSendRepo.save(dtSendProject);
	}
	
	public DateSendProject getStatus(Long id) {
		return this.dtSendRepo.findByProjectSubmitedId(id);
	}
}

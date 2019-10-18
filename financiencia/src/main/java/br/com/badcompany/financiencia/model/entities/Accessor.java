package br.com.badcompany.financiencia.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.badcompany.financiencia.model.AbstractDomainPerson;

@Entity
public class Accessor extends AbstractDomainPerson {
	private static final long serialVersionUID = 1L;
	private String instituteWork;
	
	@OneToOne
	private Specialty specialties;

	@OneToMany
	private List<Project> projectsToEval;

	public String getInstituteWork() {
		return instituteWork;
	}

	public void setInstituteWork(String instituteWork) {
		this.instituteWork = instituteWork;
	}

	public Specialty getSpecialties() {
		return specialties;
	}

	public void setSpecialties(Specialty specialties) {
		this.specialties = specialties;
	}

	public List<Project> getProjects() {
		return projectsToEval;
	}

	public void setProjects(List<Project> projects) {
		this.projectsToEval = projects;
	}
}

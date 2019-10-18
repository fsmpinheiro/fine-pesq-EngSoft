package br.com.badcompany.financiencia.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Researcher extends AbstractDomainPerson {
	private static final long serialVersionUID = 1L;
	private String instituteGraduated;
	@OneToMany
	private List<Project> projectsSubmited;

	public String getInstituteGraduated() {
		return instituteGraduated;
	}

	public void setInstituteGraduated(String instituteGraduated) {
		this.instituteGraduated = instituteGraduated;
	}

	public List<Project> getProjectsSubmited() {
		return projectsSubmited;
	}

	public void setProjectsSubmited(List<Project> projectsSubmited) {
		this.projectsSubmited = projectsSubmited;
	}
}

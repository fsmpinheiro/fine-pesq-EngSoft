package br.com.badcompany.financiencia.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.badcompany.financiencia.model.entities.Project;

@Entity
public class DateSendProject extends AbstractEntity {
	@OneToOne
	private Project projectSubmited;
	private String dateSubmission;

	public Project getProjectSubmited() {
		return projectSubmited;
	}

	public void setProjectSubmited(Project projectSubmited) {
		this.projectSubmited = projectSubmited;
	}

	public String getDateSubmission() {
		return dateSubmission;
	}

	public void setDateSubmission(String dateSubmission) {
		this.dateSubmission = dateSubmission;
	}
}

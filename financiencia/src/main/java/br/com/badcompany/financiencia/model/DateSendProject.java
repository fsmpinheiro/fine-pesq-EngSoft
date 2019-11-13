package br.com.badcompany.financiencia.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.model.enums.Eval;

@Entity
public class DateSendProject extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Project projectSubmited;
	private String dateSubmission;
	private Eval situation = Eval.INANALYSIS;

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

	public Eval getSituation() {
		return situation;
	}
}

package br.com.badcompany.financiencia.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.model.enums.Eval;

@Entity
public class DateProjectEval extends AbstractEntity {
	@OneToOne
	private Project project;
	private String valuationDate;
	private Eval approved;

	public String getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(String valuationDate) {
		this.valuationDate = valuationDate;
	}

	public Eval getApproved() {
		return approved;
	}

	public void setApproved(Eval approved) {
		this.approved = approved;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
}

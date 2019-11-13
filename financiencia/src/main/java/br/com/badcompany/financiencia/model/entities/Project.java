package br.com.badcompany.financiencia.model.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import br.com.badcompany.financiencia.model.AbstractEntity;

@Entity
public class Project extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@NotNull
	private String internalCode;
	private String title;
	private int duration;
	private String instituteWhereRealized;
	@OneToOne
	private Specialty specialty;

	public String getInternalCode() {
		return internalCode;
	}

	public void setInternalCode(String internalCode) {
		this.internalCode = internalCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getInstituteWhereRealized() {
		return instituteWhereRealized;
	}

	public void setInstituteWhereRealized(String instituteWhereRealized) {
		this.instituteWhereRealized = instituteWhereRealized;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
}

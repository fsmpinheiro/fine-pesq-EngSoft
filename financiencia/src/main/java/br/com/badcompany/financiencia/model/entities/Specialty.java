package br.com.badcompany.financiencia.model.entities;

import javax.persistence.Entity;

import br.com.badcompany.financiencia.model.AbstractEntity;

@Entity
public class Specialty extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	private int code;
	private String name;
	private String description;
	private int relevanceEconomic;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRelevanceEconomic() {
		return relevanceEconomic;
	}

	public void setRelevanceEconomic(int relevanceEconomic) {
		this.relevanceEconomic = relevanceEconomic;
	}
}

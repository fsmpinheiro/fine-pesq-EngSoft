package br.com.badcompany.financiencia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Specialty {
	@Id
	private Long id;
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

package com.badcompany.financiencia.model;

import javax.persistence.Entity;

@Entity
public class Pesquisador extends PessoaDominio {
	private String instituicaoObteveGrau;

	public String getInstituicaoObteveGrau() {
		return instituicaoObteveGrau;
	}

	public void setInstituicaoObteveGrau(String instituicaoObteveGrau) {
		this.instituicaoObteveGrau = instituicaoObteveGrau;
	}
}

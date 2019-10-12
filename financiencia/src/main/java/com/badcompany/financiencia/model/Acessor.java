package com.badcompany.financiencia.model;

import javax.persistence.Entity;

@Entity
public class Acessor extends PessoaDominio {

	private String instituicaoTrabalha;
	private String[] areasAvaliacao;

	public String getInstituicaoTrabalha() {
		return instituicaoTrabalha;
	}

	public void setInstituicaoTrabalha(String instituicaoTrabalha) {
		this.instituicaoTrabalha = instituicaoTrabalha;
	}

	public String[] getAreasAvaliacao() {
		return areasAvaliacao;
	}

	public void setAreasAvaliacao(String[] areasAvaliacao) {
		this.areasAvaliacao = areasAvaliacao;
	}
}

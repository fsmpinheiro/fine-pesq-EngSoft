package com.badcompany.financiencia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Projeto {
	@Id
	@NotNull
	private String codInterno;
	private String titulo;
	private int duracao;
	private String instituicaoRealizado;
	private String areaPesquisa;

	public String getCodInterno() {
		return codInterno;
	}

	public void setCodInterno(String codInterno) {
		this.codInterno = codInterno;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getInstituicaoRealizado() {
		return instituicaoRealizado;
	}

	public void setInstituicaoRealizado(String instituicaoRealizado) {
		this.instituicaoRealizado = instituicaoRealizado;
	}

	public String getAreaPesquisa() {
		return areaPesquisa;
	}

	public void setAreaPesquisa(String areaPesquisa) {
		this.areaPesquisa = areaPesquisa;
	}
}

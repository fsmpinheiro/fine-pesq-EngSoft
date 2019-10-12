package com.badcompany.financiencia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;
@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
//Gera auto no bd: modificar para n fazer isso
public class PessoaDominio {
	@Id
	@NotNull
	@NotEmpty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String rg;
	
	@NotNull
	@NotEmpty
	private String cpf;
	
	private String nome;
	private char sexo;
	private Date dataNascimento;
	private String grauCientifico;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getGrauCientifico() {
		return grauCientifico;
	}

	public void setGrauCientifico(String grauCientifico) {
		this.grauCientifico = grauCientifico;
	}
}

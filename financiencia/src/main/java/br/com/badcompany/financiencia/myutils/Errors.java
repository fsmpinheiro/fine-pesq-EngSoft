package br.com.badcompany.financiencia.myutils;

import java.util.List;

public class Errors {
	private List<String> errors;

	public Errors(List<String> errors) {
		super();
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}

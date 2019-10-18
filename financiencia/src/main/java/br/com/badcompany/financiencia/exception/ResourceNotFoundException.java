package br.com.badcompany.financiencia.exception;

public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String errorMessagem) {
		super(errorMessagem);
	}
}

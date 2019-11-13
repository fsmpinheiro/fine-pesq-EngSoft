package br.com.badcompany.financiencia.exception;

public class GenericException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public GenericException(String errorMessagem) {
		super(errorMessagem);
	}
}

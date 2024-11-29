package com.becker.bank.exception;

public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 3534900787324589690L;

	public BusinessException(String mensagem) {
		super(mensagem);
	}
	
	public BusinessException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}

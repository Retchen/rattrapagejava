package com.cesi.seatingplan.seatingplanapi.utilisateurService.exceptions;

public class UtilisateurException extends Exception{

	private static final long serialVersionUID = -2371627007818992254L;

	public UtilisateurException () {
		super();
	}
	
	public UtilisateurException (String message) {
		super(message);
	}
	
	public UtilisateurException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public UtilisateurException (Throwable cause) {
		super(cause);
	}
	
}

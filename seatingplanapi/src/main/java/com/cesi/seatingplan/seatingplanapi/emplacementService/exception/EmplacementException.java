package com.cesi.seatingplan.seatingplanapi.emplacementService.exception;

public class EmplacementException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmplacementException () {
		super();
	}
	
	public EmplacementException (String message) {
		super(message);
	}
	
	public EmplacementException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmplacementException (Throwable cause) {
		super(cause);
	}

}

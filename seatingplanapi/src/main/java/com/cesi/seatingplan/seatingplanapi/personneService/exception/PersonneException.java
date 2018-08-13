package com.cesi.seatingplan.seatingplanapi.personneService.exception;

public class PersonneException extends Exception {

	public PersonneException () {
		super();
	}
	
	public PersonneException (String message) {
		super(message);
	}
	
	public PersonneException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public PersonneException (Throwable cause) {
		super(cause);
	}

}

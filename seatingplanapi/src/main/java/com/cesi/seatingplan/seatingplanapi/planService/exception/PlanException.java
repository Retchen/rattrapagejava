package com.cesi.seatingplan.seatingplanapi.planService.exception;

public class PlanException extends Exception {


	public PlanException () {
		super();
	}
	
	public PlanException (String message) {
		super(message);
	}
	
	public PlanException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public PlanException (Throwable cause) {
		super(cause);
	}

}

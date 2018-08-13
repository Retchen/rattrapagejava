package com.cesi.seatingplan.seatingplanapi.commun.validation;

public abstract class AbstractValidation {

	protected static Boolean isInferieurNbCarac(String param, int value) {
		return (param.length() > value) ? false : true; 	
	}
	
	
	
}

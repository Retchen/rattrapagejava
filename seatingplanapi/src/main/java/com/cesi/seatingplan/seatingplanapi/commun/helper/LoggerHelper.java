package com.cesi.seatingplan.seatingplanapi.commun.helper;

import com.cesi.seatingplan.seatingplanapi.commun.constantes.ApplicationConstantes;

public class LoggerHelper {
// Le loggerHelper est la classe dans laquelle nous gérons les Logs.
	public static void loggerParamEntree(String service, String param) {
		if(ApplicationConstantes.LOGGER_PARAM) {
			System.out.println("======= Paramètres d'entrée : " + service + " =======");
			System.out.println(param);
		}
	}
	
	public static void loggerParamSortie(String service, String param) {
		
		if(ApplicationConstantes.LOGGER_PARAM) {
			System.out.println("======= Paramètres de sortie : " + service + " =======");
			System.out.println(param);	
		}
	}
	
}

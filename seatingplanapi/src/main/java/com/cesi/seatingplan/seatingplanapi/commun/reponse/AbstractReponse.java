package com.cesi.seatingplan.seatingplanapi.commun.reponse;

// Classe abstraite dont les réponses de chaque service héritent.

public abstract class AbstractReponse {

	private Boolean statut;
	private String message;
	
	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AbstractReponse [statut =" + statut + ", message =" + message + "]";
	}

	
	
}

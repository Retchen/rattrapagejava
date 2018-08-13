package com.cesi.seatingplan.seatingplanapi.utilisateurService.parametre;

public class ConnexionParametre {

	private String identifiant;
	private String mdp;
	
	public ConnexionParametre() {
		super();
	}
	
	public ConnexionParametre(String identifiant, String mdp) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "ConnexionParametre [identifiant=" + identifiant + ", mdp=" + mdp + "]";
	}

	
	
}

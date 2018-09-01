package com.cesi.seatingplan.seatingplanfront.entity;

/**
 * Entité de la table utilisateur
 * @author Eliott
 *
 */

public class Utilisateur {

	private Integer idUtilisateur;
	
	private String identifiant; 
	
	private String mdp;

	public Utilisateur (String identifiant, String mdp) {
        this.identifiant = identifiant;
        this.mdp = mdp;
    }

    public Utilisateur (String identifiant, String mdp, int id) {
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.idUtilisateur = id;
    }

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", identifiant=" + identifiant + ", mdp=" + mdp + "]";
	}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (idUtilisateur != null ? !idUtilisateur.equals(that.idUtilisateur) : that.idUtilisateur != null)
            return false;
        if (identifiant != null ? !identifiant.equals(that.identifiant) : that.identifiant != null) return false;
        return mdp != null ? mdp.equals(that.mdp) : that.mdp == null;
    }

    @Override
    public int hashCode() {
        int result = idUtilisateur != null ? idUtilisateur.hashCode() : 0;
        result = 31 * result + (identifiant != null ? identifiant.hashCode() : 0);
        result = 31 * result + (mdp != null ? mdp.hashCode() : 0);
        return result;
    }
}

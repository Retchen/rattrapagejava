package com.cesi.seatingplan.seatingplanfront.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personne {

    private String FORMAT_DATE = "yyyy-MM-dd";

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private Integer telephone;
    private Date date_arrivee;
    private Date date_sortie;
    private Integer poste_interne;
    private Emplacement emplacement;

    public Personne(String nom, String prenom, String email, Integer telephone, Integer poste_interne) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.poste_interne = poste_interne;
    }

    public Personne () {} //constructeur par défaut

    public Personne(int id, String nom, String prenom, String email, Integer telephone, Date date_arrivee, Date date_sortie, Integer poste_interne, Emplacement emplacement) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.date_arrivee = date_arrivee;
        this.date_sortie = date_sortie;
        this.poste_interne = poste_interne;
        this.emplacement = emplacement;
    }

    public Personne(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    public String getNom() {
        return nom;
    }

    public String setNom(String nom) {
        this.nom = nom;
        return this.nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String setPrenom(String prenom) {
        this.prenom = prenom;
        return this.prenom;
    }

    public String getEmail() {
        return email;
    }

    public String setEmail(String email) {
        this.email = email;
        return this.email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public Integer setTelephone(Integer telephone) {
        this.telephone = telephone;
        return this.telephone;
    }

    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public String getDate_arrivee_jolify() {
        return new SimpleDateFormat(FORMAT_DATE).format(date_arrivee);
    }

    public Date setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
        return this.date_arrivee;
    }

    public Date setDate_arrivee(String date_arrivee) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        this.date_arrivee = sdf.parse(date_arrivee);
        return this.date_arrivee;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public String getDate_sortie_jolify() {
        if (date_sortie != null)
            return new SimpleDateFormat(FORMAT_DATE).format(date_sortie);
        else
            return "";
    }

    public Date setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
        return this.date_sortie;
    }

    public Date setDate_sortie(String date_sortie) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        this.date_sortie = sdf.parse(date_sortie);
        return this.date_sortie;
    }

    public Integer getPoste_interne() {
        return poste_interne;
    }

    public Integer setPoste_interne(Integer poste_interne) {
        this.poste_interne = poste_interne;
        return this.poste_interne;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public Emplacement setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
        return emplacement;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", date_arrivee=" + date_arrivee +
                ", date_sortie=" + date_sortie +
                ", poste_interne=" + poste_interne +
                ", emplacement=" + emplacement +
                '}';
    }
}

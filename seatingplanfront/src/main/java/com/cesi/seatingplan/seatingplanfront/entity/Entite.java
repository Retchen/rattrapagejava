package com.cesi.seatingplan.seatingplanfront.entity;

public class Entite {
    private int id;
    private String nom;
    private int nb_place;
    private double largeur;
    private double longueur;


    public Entite(int id, String nom, int nb_place, double longueur, double largeur) {
        this.id = id;
        this.nom = nom;
        this.nb_place = nb_place;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public Entite(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public Entite setId(int id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Entite setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public int getNb_place() {
        return nb_place;
    }

    public Entite setNb_place(int nb_place) {
        this.nb_place = nb_place;
        return this;
    }

    public double getLargeur() {
        return largeur;
    }

    public Entite setLargeur(double largeur) {
        this.largeur = largeur;
        return this;
    }

    public double getLongueur() {
        return longueur;
    }

    public Entite setLongueur(double longueur) {
        this.longueur = longueur;
        return this;
    }

    @Override
    public String toString() {
        return "Entite{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nb_place=" + nb_place +
                ", largeur=" + largeur +
                ", longueur=" + longueur +
                '}';
    }
}

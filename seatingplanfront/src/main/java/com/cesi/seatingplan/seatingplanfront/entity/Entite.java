package com.cesi.seatingplan.seatingplanfront.entity;

public class Entite {
    private int id;
    private String nom;
    private double largeur;
    private double longueur;


    public Entite(int id, String nom, double longueur, double largeur) {
        this.id = id;
        this.nom = nom;
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
                ", largeur=" + largeur +
                ", longueur=" + longueur +
                '}';
    }
}

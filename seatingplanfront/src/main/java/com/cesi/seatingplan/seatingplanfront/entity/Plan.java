package com.cesi.seatingplan.seatingplanfront.entity;

import java.util.List;

public class Plan {

    private int id;
    private String nom;
    private String image;
    private int image_longueur;
    private int image_largeur;
    private int echelle_pixel;
    private int echelle_cm;
    private List<Emplacement> emplacements;

    public Plan(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Plan(int id, String nom, String image, int image_longueur, int image_largeur, int echelle_pixel, int echelle_cm) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.image_longueur = image_longueur;
        this.image_largeur = image_largeur;
        this.echelle_pixel = echelle_pixel;
        this.echelle_cm = echelle_cm;
    }

    public Plan() {

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

    public String getImage() {
        return image;
    }

    public String setImage(String image) {
        this.image = image;
        return this.image;
    }

    public int getImage_longueur() { return image_longueur; }

    public Plan setImage_longueur(int image_longueur) {
        this.image_longueur = image_longueur;
        return this;
    }

    public int getImage_largeur() { return image_largeur; }

    public Plan setImage_largeur(int image_largeur) {
        this.image_largeur = image_largeur;
        return this;
    }

    public int getEchelle_pixel() {
        return echelle_pixel;
    }

    public int setEchelle_pixel(int echelle_pixel) {
        this.echelle_pixel = echelle_pixel;
        return this.echelle_pixel;
    }

    public int getEchelle_cm() {
        return echelle_cm;
    }

    public int setEchelle_cm(int echelle_cm) {
        this.echelle_cm = echelle_cm;
        return this.echelle_cm;
    }

    public Plan(String nom, String image, int image_longueur, int image_largeur, int echelle_pixel, int echelle_cm) {
        this.nom = nom;
        this.image = image;
        this.image_longueur = image_longueur;
        this.image_largeur = image_largeur;
        this.echelle_pixel = echelle_pixel;
        this.echelle_cm = echelle_cm;
    }

    public List<Emplacement> getEmplacements() {
        return emplacements;
    }

    public List<Emplacement> setEmplacements(List<Emplacement> emplacements) {
        this.emplacements = emplacements;
        return this.emplacements;
    }

    public int getNbEmplacements () {
        return this.getEmplacements().size();
    }
    public int getNbEmplacementsLibres () {
        int size = 0;
        for (Emplacement emp : this.getEmplacements()) {
            if(!emp.isOccupe()) size ++;
        }
        return size;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", image_longueur=" + image_longueur +
                ", image_largeur=" + image_largeur +
                ", echelle_pixel=" + echelle_pixel +
                ", echelle_cm=" + echelle_cm +
                ", emplacements=" + emplacements +
                '}';
    }
}

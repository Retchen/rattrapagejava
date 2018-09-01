package com.cesi.seatingplan.seatingplanfront.entity;

import java.util.List;

public class Emplacement {
    private int id;
    private int pos_x;
    private int pos_y;
    private String orientation;
    private Entite entite;
    private List<Personne> personnes;
    private boolean occupe;
    private int idPlan;

    public Emplacement(int id, List<Personne> personnes) {
        this.id = id;
        this.personnes = personnes;
    }

    public Emplacement(int pos_x, int pos_y, String orientation, Entite entite, List<Personne> personnes, int idPlan) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.orientation = orientation;
        this.entite = entite;
        this.personnes = personnes;
        this.idPlan = idPlan;
    }

    public Emplacement(int id) {

        this.id = id;
    }

    public Emplacement(int pos_x, int pos_y, String orientation, Entite entite, List<Personne> personnes, boolean occupe, int idPlan) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.orientation = orientation;

        this.entite = entite;
        this.personnes = personnes;
        this.occupe = occupe;
        this.idPlan = idPlan;
    }

    public Emplacement(int id, int pos_x, int pos_y, String orientation, Entite entite, List<Personne> personnes, boolean occupe, int idPlan) {
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.orientation = orientation;
        this.entite = entite;
        this.personnes = personnes;
        this.occupe = occupe;
        this.idPlan = idPlan;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public int getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(int idPlan) {
        this.idPlan = idPlan;
    }

    public Emplacement(int id, int pos_x, int pos_y, String orientation, Entite entite, boolean occupe) {
        this.id = id;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.orientation = orientation;
        this.entite = entite;
        this.occupe = occupe;
    }

    public Emplacement() {

    }

    public int getId() {
        return id;
    }

    public Emplacement setId(int id) {
        this.id = id;
        return this;
    }

    public int getPos_x() {
        return pos_x;
    }

    public Emplacement setPos_x(int pos_x) {
        this.pos_x = pos_x;
        return this;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Emplacement setPos_y(int pos_y) {
        this.pos_y = pos_y;
        return this;
    }

    public String getOrientation() {
        return orientation;
    }

    public Emplacement setOrientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    public Entite getEntite() {
        return entite;
    }

    public Emplacement setEntite(Entite entite) {
        this.entite = entite;
        return this;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public Emplacement setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emplacement that = (Emplacement) o;

        if (id != that.id) return false;
        if (pos_x != that.pos_x) return false;
        if (pos_y != that.pos_y) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pos_x;
        result = 31 * result + pos_y;
        return result;
    }

    @Override
    public String toString() {
        return "Emplacement{" +
                "id=" + id +
                ", pos_x=" + pos_x +
                ", pos_y=" + pos_y +
                ", orientation='" + orientation + '\'' +
                ", entite=" + entite +
                ", personnes=" + personnes +
                ", occupe=" + occupe +
                '}';
    }
}

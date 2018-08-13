package com.cesi.seatingplan.seatingplanapi.commun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="emplacement")
public class Emplacement {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name="pos_x")
	private Integer posX; 
	
	@Column(name="pos_y")
	private Integer posY; 
	
	private String orientation;
	
	@ManyToOne
	@JoinColumn(name = "id_entite")
	private Entite entite;
	
	@ManyToOne
	@JoinColumn(name = "id_plan")
	private Plan plan;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Entite getEntite() {
		return entite;
	}

	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "Emplacement [id=" + id + ", posX=" + posX + ", posY=" + posY + ", orientation=" + orientation
				+ ", entite=" + entite + ", plan=" + plan + "]";
	}
	
	
}

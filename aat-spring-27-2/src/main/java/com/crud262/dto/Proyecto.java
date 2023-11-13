package com.crud262.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="proyectos")
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int horas;
	

	 @ManyToMany(mappedBy = "proyectos")
	 @JsonIgnoreProperties("proyectos")
	 private Set<Cientifico> cientificos;
	 
	public Proyecto(int id, String nombre, int horas, Set<Cientifico> cientificos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.cientificos = cientificos;
	}
	public Proyecto() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public Set<Cientifico> getCientificos() {
		return cientificos;
	}
	public void setCientificos(Set<Cientifico> cientificos) {
		this.cientificos = cientificos;
	}
	
	
	
	

}

package com.crud262.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="cientificos")
public class Cientifico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre ;
	
	 	@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "cientificos_proyectos",
	        joinColumns = { @JoinColumn(name = "cientifico_id") },
	        inverseJoinColumns = { @JoinColumn(name = "proyecto_id") }
	    )
	    	    
	    @JsonIgnoreProperties("cientificos")
	 
	 private List<Proyecto> proyectos;
	
	public Cientifico() {
	}

	public Cientifico(int id, String nombre, List<Proyecto> proyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyectos = proyectos;
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

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	
	

}

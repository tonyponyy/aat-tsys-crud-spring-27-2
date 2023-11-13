package com.crud262.service;

import java.util.List;

import com.crud262.dto.Cientifico;


public interface ICientificoService {
	
	//Listar todos
	public List<Cientifico> listarCientificos();
	
	//Listar por id
	public Cientifico cientificoXID(Integer id); 
	
	//Guardar
	public Cientifico guardarCientifico(Cientifico Fabricante);
	
	//Actualizar
	public Cientifico actualizarCientifico(Cientifico Fabricante);
	
	//Eliminar
	public void eliminarCientifico(Integer id);

	
}
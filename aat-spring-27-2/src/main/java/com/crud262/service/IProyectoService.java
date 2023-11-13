package com.crud262.service;

import java.util.List;

import com.crud262.dto.Proyecto;


public interface IProyectoService {
	
	//Listar todos
	public List<Proyecto> listarProyectos();
	
	//Listar por id
	public Proyecto proyectoXID(Integer id); 
	
	//Guardar
	public Proyecto guardarProyecto(Proyecto Fabricante);
	
	//Actualizar
	public Proyecto actualizarProyecto(Proyecto Fabricante);
	
	//Eliminar
	public void eliminarProyecto(Integer id);

	
}
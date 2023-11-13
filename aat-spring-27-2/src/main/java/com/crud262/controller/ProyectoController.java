package com.crud262.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud262.dto.Proyecto;
import com.crud262.service.IProyectoServiceImpl;


@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
	@Autowired
	private IProyectoServiceImpl proyectoServiceImpl;

	@GetMapping("/all")
	public List<Proyecto> listarProyectos(){
		return proyectoServiceImpl.listarProyectos();
	}
	@PostMapping("/add")
	public Proyecto salvarproyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	@GetMapping("/{id}")
	public Proyecto proyectoXID(@PathVariable Integer id) {
		Proyecto proyecto_xid= new Proyecto();	
		proyecto_xid=proyectoServiceImpl.proyectoXID(id);
		return proyecto_xid;
	}
	
	@PutMapping("/{id}")
	public Proyecto actualizarproyecto(@PathVariable Integer id,@RequestBody Proyecto proyecto) {
		
		Proyecto proyecto_seleccionado= new Proyecto();
		Proyecto proyecto_actualizado= new Proyecto();
		
		proyecto_seleccionado= proyectoServiceImpl.proyectoXID(id);
		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setHoras(proyecto.getHoras());
		proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(proyecto_seleccionado);
		System.out.println("El proyecto actualizado es: "+ proyecto_actualizado);
		return proyecto_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarproyecto(@PathVariable Integer id) {
		proyectoServiceImpl.eliminarProyecto(id);
		System.out.println("proyecto eliminado");
	}
	


}
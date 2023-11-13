package com.crud262.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.crud262.dto.Cientifico;
import com.crud262.dto.Proyecto;
import com.crud262.service.ICientificoServiceImpl;
import com.crud262.service.IProyectoServiceImpl;




@RestController
@RequestMapping("/cientificos")
public class CientificoController {
	@Autowired
	private ICientificoServiceImpl cientificoServiceImpl;
	@Autowired
	private IProyectoServiceImpl proyectoServiceImpl ;
	private EntityManager entityManager;

	@GetMapping("/all")
	public List<Cientifico> listarCientificos(){
		return cientificoServiceImpl.listarCientificos();
	}
	@PostMapping("/add")
	public Cientifico salvarcientifico(@RequestBody Cientifico cientifico) {
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}
	@GetMapping("/{id}")
	public Cientifico cientificoXID(@PathVariable Integer id) {
		Cientifico cientifico_xid= new Cientifico();	
		cientifico_xid=cientificoServiceImpl.cientificoXID(id);
		return cientifico_xid;
	}
	
	@PutMapping("/{id}")
	public Cientifico actualizarcientifico(@PathVariable Integer id,@RequestBody Cientifico cientifico) {
		
		Cientifico cientifico_seleccionado= new Cientifico();
		Cientifico cientifico_actualizado= new Cientifico();
		
		cientifico_seleccionado= cientificoServiceImpl.cientificoXID(id);
		cientifico_seleccionado.setNombre(cientifico.getNombre());
		cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(cientifico_seleccionado);
		System.out.println("El cientifico actualizado es: "+ cientifico_actualizado);
		return cientifico_actualizado;
	}
	
	@DeleteMapping("/{id}")
	public void eliminarcientifico(@PathVariable Integer id) {
		cientificoServiceImpl.eliminarCientifico(id);
		System.out.println("cientifico eliminado");
	}
	
	@PostMapping("/guardarproyecto/{id}")
	@Transactional
	public ResponseEntity<String> salvarCientificoProyecto(@RequestBody Cientifico cientifico, @PathVariable int id) {
	    // Guarda el cientifico
	    Cientifico cientificoGuardado = cientificoServiceImpl.guardarCientifico(cientifico);

	    // Obtiene el proyecto por su ID
	    Proyecto proyecto = proyectoServiceImpl.proyectoXID(id);

	    // Asocia el cientifico con el proyecto
	    if (proyecto != null) {
	        cientificoGuardado.getProyectos().add(proyecto);
	        proyecto.getCientificos().add(cientificoGuardado);
	        entityManager.persist(cientificoGuardado);
	        entityManager.persist(proyecto);
	    }

	    return ResponseEntity.ok("Cientifico asociado con éxito al proyecto");
	    
	}
	

    
	


}
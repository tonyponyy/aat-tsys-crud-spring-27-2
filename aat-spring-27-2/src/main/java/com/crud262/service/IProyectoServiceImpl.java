package com.crud262.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud262.dao.ICientificoDAO;
import com.crud262.dao.IProyectoDAO;
import com.crud262.dto.Cientifico;
import com.crud262.dto.Proyecto;


@Service
public class IProyectoServiceImpl implements IProyectoService {
	
	@Autowired
	IProyectoDAO iproyectoDAO;

	@Autowired
	ICientificoDAO icientificoDAO;

	//Listar todos
		public List<Proyecto> listarProyectos(){
			return iproyectoDAO.findAll();
		};
		
		
		//Listar por id
		public Proyecto proyectoXID(Integer id) {
			return iproyectoDAO.findById(id).get();
		}; 
		
		//Guardar
		public Proyecto guardarProyecto(Proyecto proyecto) {
			return iproyectoDAO.save(proyecto);
		};
		
		//Actualizar
		public Proyecto actualizarProyecto(Proyecto proyecto) {
			return iproyectoDAO.save(proyecto);
		};
		
		//Eliminar
		public void eliminarProyecto(Integer id) {
			iproyectoDAO.deleteById(id);
		}
		
		
	   
	


}
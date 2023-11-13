package com.crud262.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud262.dao.ICientificoDAO;
import com.crud262.dto.Cientifico;


@Service
public class ICientificoServiceImpl implements ICientificoService {
	
	@Autowired
	ICientificoDAO icientificoDAO;

	//Listar todos
		public List<Cientifico> listarCientificos(){
			return icientificoDAO.findAll();
		};
		
		
		//Listar por id
		public Cientifico cientificoXID(Integer id) {
			return icientificoDAO.findById(id).get();
		}; 
		
		//Guardar
		public Cientifico guardarCientifico(Cientifico cientifico) {
			return icientificoDAO.save(cientifico);
		};
		
		//Actualizar
		public Cientifico actualizarCientifico(Cientifico cientifico) {
			return icientificoDAO.save(cientifico);
		};
		
		//Eliminar
		public void eliminarCientifico(Integer id) {
			icientificoDAO.deleteById(id);
		}


}
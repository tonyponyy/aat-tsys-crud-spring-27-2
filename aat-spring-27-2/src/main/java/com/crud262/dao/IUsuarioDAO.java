package com.crud262.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud262.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
package com.badcompany.financiencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.badcompany.financiencia.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByLogin(String login);
}

package com.badcompany.financiencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.badcompany.financiencia.model.Usuario;
import com.badcompany.financiencia.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository uRepo;
	
	public void adicionarUsuario(Usuario u) {
		u.setSenha(new BCryptPasswordEncoder().encode(u.getSenha()));
		this.uRepo.save(u);
	}
}

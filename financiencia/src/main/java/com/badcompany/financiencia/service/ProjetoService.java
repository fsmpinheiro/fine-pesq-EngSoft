package com.badcompany.financiencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badcompany.financiencia.model.Projeto;
import com.badcompany.financiencia.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projRepo;

	public void addProjeto(Projeto p) {
//		add projeto e gerar o codigo
	}
}

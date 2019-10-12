package com.badcompany.financiencia.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badcompany.financiencia.model.Pesquisador;

@RestController
public class IndexController {
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
		Pesquisador p = new Pesquisador();
		p.setCpf("234234252");
		p.setDataNascimento(new Date());
		p.setGrauCientifico("Mestre em Engenharia de Software");
		p.setInstituicaoObteveGrau("Universidade Federal do Ceará");
		p.setNome("Ítalo");
		p.setRg("23423423");
		p.setSexo('M');
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
}

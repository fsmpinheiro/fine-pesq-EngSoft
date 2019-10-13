package com.badcompany.financiencia.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.badcompany.financiencia.model.Projeto;

@RestController
@RequestMapping("/acessor")
public class AcessorController {

	@GetMapping("/home")
	@PreAuthorize("hasRole('ACESSOR')")
	public ResponseEntity<?> boasVindasAcessor() {
		return new ResponseEntity<>(Arrays.asList(new Projeto(), new Projeto(), new Projeto()), HttpStatus.OK);
	}
}

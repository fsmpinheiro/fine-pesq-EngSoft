package com.badcompany.financiencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PesquisadorController {
	public ResponseEntity<?> boasVindasPesquisador() {
		return new ResponseEntity<> (HttpStatus.OK);
	}
}

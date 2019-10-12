package com.badcompany.financiencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessorController {
	public ResponseEntity<?> boasVindasAcessor() {
		return new ResponseEntity<> (HttpStatus.OK);
	}
}

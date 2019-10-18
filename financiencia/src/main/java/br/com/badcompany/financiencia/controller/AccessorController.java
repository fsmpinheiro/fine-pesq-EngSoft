package br.com.badcompany.financiencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.Accessor;
import br.com.badcompany.financiencia.service.AccessorService;

@RestController
@RequestMapping("/v1/accessor")
public class AccessorController {

	@Autowired
	private AccessorService aServ;

	@PostMapping("/register")
	public ResponseEntity<?> registerAccessor(@RequestBody Accessor a) {
		aServ.addAccessor(a);
		return new ResponseEntity<>(a, HttpStatus.OK);
	}
	
	@GetMapping("/projects")
	public ResponseEntity<?> getProjectsToEvaluate(@PathVariable("id") Long id) {
		return new ResponseEntity<>(aServ.projectsToEvaluate(id), HttpStatus.OK); 
	}
	
}

package br.com.badcompany.financiencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.Researcher;
import br.com.badcompany.financiencia.service.ResearcherService;

@RestController
@RequestMapping("/v1/researcher")
public class ResearcherController {
	
	@Autowired
	private ResearcherService rServ;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerResearcher(@RequestBody Researcher r) {
		rServ.addResearcher(r);
		return new ResponseEntity<> (r, HttpStatus.OK);
	}
}

package br.com.badcompany.financiencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.model.entities.Researcher;

@RestController
@RequestMapping("/v1/index")
public class IndexController {
	
	@GetMapping("/free")
	public ResponseEntity<?> freeForAll() {
		return new ResponseEntity<> (new Researcher(), HttpStatus.OK);
	}
	
	@GetMapping("/researcher")
//	@PreAuthorize("hasRole('RESEARCHER')")
	public ResponseEntity<?> forResearcher() {
		return new ResponseEntity<> (new Researcher(), HttpStatus.OK);
	}
	
	@GetMapping("/accessor")
//	@PreAuthorize("hasRole('ACCESSOR')")
	public ResponseEntity<?> forAccessor() {
		return new ResponseEntity<> (new Accessor(), HttpStatus.OK);
	}
	
	@GetMapping("/project")
	public ResponseEntity<?> forProject() {
		return new ResponseEntity<> (new Project(), HttpStatus.OK);
	}
}

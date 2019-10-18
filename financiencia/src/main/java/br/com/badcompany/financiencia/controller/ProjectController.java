package br.com.badcompany.financiencia.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.exception.GenericException;
import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.myutils.MessageJson;
import br.com.badcompany.financiencia.service.ProjectService;

@RestController
@RequestMapping("/v1/project")
public class ProjectController {
	@Autowired
	private ProjectService pServ;

	@PostMapping("/submit")
	public ResponseEntity<?> submitANewProject(@RequestBody Project p) {
		pServ.addProject(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/evaluate")
//	@PreAuthorize("hasRole('ACCESSOR')
	public ResponseEntity<?> approvedProject(@RequestParam("id") Long id, 
			@RequestParam("approved") boolean result) {
		try {			
			pServ.evalProject(id, result);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch(GenericException e) {
			return new ResponseEntity<>(new MessageJson(e.getMessage()), HttpStatus.NOT_FOUND); 
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllProjects() {
		return new ResponseEntity<> (this.pServ.projectsList(), HttpStatus.OK);
	}
	
	@GetMapping("/state/{id}")
	public ResponseEntity<?> getStateOfAProject(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<> (pServ.stateOf(id), HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<> (new MessageJson("Project not found"), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchProject(@PathVariable("id") Long id) {
		return new ResponseEntity<>(pServ.getOneProject(id), HttpStatus.OK);
	}
}

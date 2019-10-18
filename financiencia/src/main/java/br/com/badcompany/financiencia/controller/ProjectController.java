package br.com.badcompany.financiencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.Project;
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
}

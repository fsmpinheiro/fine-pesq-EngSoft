package br.com.badcompany.financiencia.controller;

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
import br.com.badcompany.financiencia.myutils.Errors;
import br.com.badcompany.financiencia.myutils.MessageJson;
import br.com.badcompany.financiencia.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Endpoint de projetos")
@RestController
@RequestMapping("/v1/project")
public class ProjectController {
	@Autowired
	private ProjectService pServ;
	
	@ApiOperation(value="Cadastro de um projeto")
	@PostMapping("/submit")
	public ResponseEntity<?> submitANewProject(@RequestBody Project p) {
		if (pServ.addProject(p))
			return new ResponseEntity<>(p, HttpStatus.CREATED);
		return new ResponseEntity<>(new MessageJson("Something wrong happened"), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ApiOperation(value="Avaliação de um projeto")
	@GetMapping("/evaluate")
//	@PreAuthorize("hasRole('ACCESSOR')
	public ResponseEntity<?> approvedProject(@RequestParam("id") Long id, 
			@RequestParam("approved") boolean result) {
		try {			
			pServ.evalProject(id, result);
			String situation = "disapproved";
			if (result)
				situation = "approved";
			
			return new ResponseEntity<>(new MessageJson("Project " + situation), HttpStatus.OK);
		} catch(GenericException e) {
			return new ResponseEntity<>(new MessageJson(e.getMessage()), HttpStatus.NOT_FOUND); 
		}
	}
	
	@ApiOperation(value="Listagem de todos os projetos")
	@GetMapping("/list")
	public ResponseEntity<?> getAllProjects() {
		return new ResponseEntity<> (this.pServ.projectsList(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Consulta do estado de um projeto (aprovado, desaprovado ou em análise)")
	@GetMapping("/state/{id}")
	public ResponseEntity<?> getStateOfAProject(@PathVariable("id") Long id) {
		if (this.pServ.validateProject(id).isEmpty())
			return new ResponseEntity<> (pServ.stateOf(id), HttpStatus.OK);
		
		return new ResponseEntity<> (new Errors(this.pServ.validateProject(id)), HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value="Busca por id de um projeto")
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchProject(@PathVariable("id") Long id) {
		if (pServ.isProjectExists(id))
			return new ResponseEntity<>(pServ.getOneProject(id), HttpStatus.FOUND);
		return new ResponseEntity<>(new MessageJson("Project not found"), HttpStatus.NOT_FOUND);
	}
	
	@ApiOperation(value="Busca por código de um projeto")
	@GetMapping("/search/code/{internalCode}")
	public ResponseEntity<?> searchProjectByInternalCode(@PathVariable("internalCode") String internalCode) {
		if (!internalCode.isEmpty())
			return new ResponseEntity<>(pServ.getProjectByIntenalCode(internalCode), HttpStatus.FOUND);
		return new ResponseEntity<>(new MessageJson("Project not found"), HttpStatus.NOT_FOUND);
	}
}

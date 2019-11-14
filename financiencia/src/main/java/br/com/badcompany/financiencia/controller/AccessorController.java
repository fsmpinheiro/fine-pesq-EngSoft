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

import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.myutils.MessageJson;
import br.com.badcompany.financiencia.service.AccessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Endpoint de acessor")
@RestController
@RequestMapping("/v1/accessor")
public class AccessorController {

	@Autowired
	private AccessorService aServ;
	
	@ApiOperation(value="Cadastro de acessor")
	@PostMapping("/register")
	public ResponseEntity<?> registerAccessor(@RequestBody Accessor a) {
		if(aServ.addAccessor(a) == null) {
			return new ResponseEntity<>(new MessageJson("Accessor already exists"), HttpStatus.BAD_REQUEST);
		}
		aServ.addAccessor(a);
		return new ResponseEntity<>(a, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Lista de projetos para o acessor avaliar ")
	@GetMapping("/{idAccessor}/projects")
	public ResponseEntity<?> getProjectsToEvaluate(@PathVariable("idAccessor") Long id) {
		if(aServ.accessorExistsById(id)) {			
			return new ResponseEntity<>(aServ.projectsToEvaluate(id), HttpStatus.OK); 
		}
		return new ResponseEntity<>(new MessageJson("Accessor not found"), HttpStatus.NOT_FOUND);
	}
}

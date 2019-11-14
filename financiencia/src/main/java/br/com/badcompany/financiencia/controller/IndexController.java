package br.com.badcompany.financiencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.entities.Accessor;
import br.com.badcompany.financiencia.model.entities.Project;
import br.com.badcompany.financiencia.model.entities.Researcher;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Endpoint de ajuda no desenvolvimento")
@RestController
@RequestMapping("/v1/index")
public class IndexController {
	
	@ApiOperation(value="Retorna um exemplo de pesquisador")
	@GetMapping("/researcher")
//	@PreAuthorize("hasRole('RESEARCHER')")
	public ResponseEntity<?> forResearcher() {
		return new ResponseEntity<> (new Researcher(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna um exemplo de acessor")
	@GetMapping("/accessor")
//	@PreAuthorize("hasRole('ACCESSOR')")
	public ResponseEntity<?> forAccessor() {
		return new ResponseEntity<> (new Accessor(), HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna um exemplo de projeto")
	@GetMapping("/project")
	public ResponseEntity<?> forProject() {
		return new ResponseEntity<> (new Project(), HttpStatus.OK);
	}
}

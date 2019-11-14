package br.com.badcompany.financiencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.entities.Researcher;
import br.com.badcompany.financiencia.myutils.MessageJson;
import br.com.badcompany.financiencia.service.ResearcherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Endpoint de pesquisador")
@RestController
@RequestMapping("/v1/researcher")
public class ResearcherController {
	
	@Autowired
	private ResearcherService rServ;
	
	@ApiOperation(value="Cadastrar um pequisador")
	@PostMapping("/register")
	public ResponseEntity<?> registerResearcher(@RequestBody Researcher r) {
		if (rServ.addResearcher(r))
			return new ResponseEntity<> (r, HttpStatus.CREATED);
			
		return new ResponseEntity<> (new MessageJson("The researcher cannot be registered without a project."), HttpStatus.BAD_REQUEST);
	}
}

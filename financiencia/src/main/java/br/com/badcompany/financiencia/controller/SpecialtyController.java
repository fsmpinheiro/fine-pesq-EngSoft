package br.com.badcompany.financiencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.repository.SpecialtyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Endpoint de especialidades")
@RestController
@RequestMapping("/v1/specialty")
public class SpecialtyController {
	
	@Autowired
	private SpecialtyRepository specialRepo;
	
	@ApiOperation(value="Lista de especialidades")
	@GetMapping("/list")
	public ResponseEntity<?> getAllSpecialty() {
		return new ResponseEntity<>(this.specialRepo.findAll(), HttpStatus.OK);
	}
}

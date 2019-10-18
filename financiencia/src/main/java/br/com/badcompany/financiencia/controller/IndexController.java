package br.com.badcompany.financiencia.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.badcompany.financiencia.model.Researcher;
import br.com.badcompany.financiencia.myutils.MessageJson;

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
		return new ResponseEntity<> (new MessageJson("Researcher"), HttpStatus.OK);
	}
	
	@GetMapping("/accessor")
//	@PreAuthorize("hasRole('ACCESSOR')")
	public ResponseEntity<?> forAccessor() {
		return new ResponseEntity<> (new MessageJson("Accessor"), HttpStatus.OK);
	}
}

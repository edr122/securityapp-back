package com.example.segurityapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.segurityapp.domain.Entrant;
import com.example.segurityapp.service.EntrantServiceImpl;

@RestController
@RequestMapping("/api/segurityapp/")
@CrossOrigin
public class EntrantController {
	
	@Autowired EntrantServiceImpl entrantService;
	
	@GetMapping("entrants")
	public Iterable<Entrant> getAllPTs(){
		return entrantService.findAll();
	}
	
	@GetMapping("entrantspaged")
	public Iterable<Entrant> getAllPTs(Pageable pageable){
		return entrantService.findAll(pageable);
	}
	
	@PostMapping("entrants")
	public ResponseEntity<?> saveOrUpdateEntrant(@RequestBody Entrant entrant){
		Entrant newE = entrantService.saveOrUpdateEntrant(entrant);
		return new ResponseEntity<Entrant>(newE,HttpStatus.CREATED);
	}
	
	@GetMapping("entrants/{e_id}")
	public ResponseEntity<?> getEById(@PathVariable Integer e_id){
		Optional<Entrant> entrant = entrantService.findById(e_id);
		return new ResponseEntity<Optional<Entrant>>(entrant, HttpStatus.OK);
	}
	
	@DeleteMapping("entrants/{e_id}")
	public ResponseEntity<?> delete(@PathVariable Integer e_id){
		entrantService.delete(e_id);
		return new ResponseEntity<String>("entrant removed",HttpStatus.OK);
	}
}

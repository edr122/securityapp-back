package com.example.segurityapp.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.segurityapp.domain.EntrantType;
import com.example.segurityapp.service.EntrantTypeServiceImpl;

@RestController
@RequestMapping("/api/segurityapp/")
@CrossOrigin
public class EntrantTypeController {
	
	@Autowired EntrantTypeServiceImpl typeEntrantService;
	
	@GetMapping("entrantsType")
	public Iterable<EntrantType> getAllPTs(){
		return typeEntrantService.findAll();
	}
	
	@GetMapping("entrantsTypePaged")
	public Iterable<EntrantType> getAllPTs(Pageable pageable){
		return typeEntrantService.findAll(pageable);
	}
	
	@PostMapping("entrantsType")
	public ResponseEntity<?> saveOrUpdateEntrant(@RequestBody EntrantType typeEntrant){
		EntrantType newTE = typeEntrantService.saveOrUpdateEntrant(typeEntrant);
		return new ResponseEntity<EntrantType>(newTE,HttpStatus.CREATED);
	}
	
	@GetMapping("entrantsType/{te_id}")
	public ResponseEntity<?> getEById(@PathVariable Integer te_id){
		Optional<EntrantType> entrant = typeEntrantService.findById(te_id);
		return new ResponseEntity<Optional<EntrantType>>(entrant, HttpStatus.OK);
	}
}

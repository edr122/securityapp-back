package com.example.segurityapp.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.segurityapp.domain.TypeEntrant;
import com.example.segurityapp.service.TypeEntrantServiceImpl;

@RestController
@RequestMapping("/api/segurityapp/typeentrants")
@CrossOrigin
public class TypeEntrantController {
	
	@Autowired TypeEntrantServiceImpl typeEntrantService;
	
	@GetMapping("/all")
	public Iterable<TypeEntrant> getAllPTs(){
		return typeEntrantService.findAll();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> saveOrUpdateEntrant(@RequestBody TypeEntrant typeEntrant){
		TypeEntrant newTE = typeEntrantService.saveOrUpdateEntrant(typeEntrant);
		return new ResponseEntity<TypeEntrant>(newTE,HttpStatus.CREATED);
	}
	
	@GetMapping("/{te_id}")
	public ResponseEntity<?> getEById(@PathVariable Integer te_id){
		Optional<TypeEntrant> entrant = typeEntrantService.findById(te_id);
		return new ResponseEntity<Optional<TypeEntrant>>(entrant, HttpStatus.OK);
	}
}
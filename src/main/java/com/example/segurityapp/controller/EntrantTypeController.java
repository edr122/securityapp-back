package com.example.segurityapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.segurityapp.dto.EntrantTypeDto;
import com.example.segurityapp.service.EntrantTypeService;
import com.example.segurityapp.payloads.ApiResponse;

@RestController
@RequestMapping("/api/segurityapp/")
@CrossOrigin
public class EntrantTypeController {

	@Autowired
	EntrantTypeService entrantTypeService;

//	@GetMapping("entrantsType")
//	public Iterable<EntrantType> getAllPTs(){
//		return entrantTypeService.findAll();
//	}
//	
//	@GetMapping("entrantsTypePaged")
//	public Iterable<EntrantType> getAllPTs(Pageable pageable){
//		return entrantTypeService.findAll(pageable);
//	}

	@PostMapping("entrantTypes")
	public ResponseEntity<EntrantTypeDto> saveOrUpdateEntrant(@RequestBody EntrantTypeDto entrantsTypeDto) {
		EntrantTypeDto savedEntrantType = entrantTypeService.createEntrant(entrantsTypeDto);
		return new ResponseEntity<EntrantTypeDto>(savedEntrantType, HttpStatus.CREATED);
	}

	@GetMapping("entrantTypes")
	public ResponseEntity<List<EntrantTypeDto>> getAllEntrantTypes() {
		List<EntrantTypeDto> entrantTypes = entrantTypeService.getAllEntrantTypes();
		return new ResponseEntity<List<EntrantTypeDto>>(entrantTypes, HttpStatus.OK);
	}

	@GetMapping("entrantTypes/{entrantTypeId}")
	public ResponseEntity<EntrantTypeDto> getCategoryById(@PathVariable Integer entrantTypeId) {
		EntrantTypeDto entrantTypeDto = entrantTypeService.getEntrantTypeById(entrantTypeId);
		return new ResponseEntity<EntrantTypeDto>(entrantTypeDto, HttpStatus.OK);
	}

	@DeleteMapping("entrantTypes/{entrantTypeId}")
	public ResponseEntity<ApiResponse> deleteEntrantType(@PathVariable Integer entrantTypeId) {
		entrantTypeService.deleteEntrantType(entrantTypeId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Entrant Type deleted Successfully", true),
				HttpStatus.OK);
	}

	@PutMapping("entrantTypes/{entrantTypeId}")
	public ResponseEntity<EntrantTypeDto> updateEntrantType(@RequestBody EntrantTypeDto entrantTypeDto,
			@PathVariable Integer entrantTypeId) {
		EntrantTypeDto updatedCategory = entrantTypeService.updateEntrantType(entrantTypeDto, entrantTypeId);
		return new ResponseEntity<EntrantTypeDto>(updatedCategory, HttpStatus.OK);
	}
}

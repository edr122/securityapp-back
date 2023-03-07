package com.example.segurityapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.segurityapp.dto.EntrantTypeListAllDto;
import com.example.segurityapp.service.EntrantTypeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import com.example.segurityapp.payloads.ApiResponse;

@RestController
@RequestMapping("/api/securityapp/")
@SecurityRequirement(name = "Authorization")
@CrossOrigin
public class EntrantTypeController {

	@Autowired
	EntrantTypeService entrantTypeService;

	@PostMapping("entrantTypes")
	@Operation(summary = "Save Entrant Type")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<EntrantTypeDto> saveOrUpdateEntrantType(@RequestBody @Valid EntrantTypeDto entrantsTypeDto) {
		EntrantTypeDto savedEntrantType = entrantTypeService.createEntrantType(entrantsTypeDto);
		return new ResponseEntity<EntrantTypeDto>(savedEntrantType, HttpStatus.CREATED);
	}

	@GetMapping("entrantTypes")
	@Operation(summary = "Get All Entrant Types")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<EntrantTypeDto>> getAllEntrantTypes() {
		List<EntrantTypeDto> entrantTypes = entrantTypeService.getAllEntrantTypes();
		return new ResponseEntity<List<EntrantTypeDto>>(entrantTypes, HttpStatus.OK);
	}
	
	@GetMapping("entrantTypesAll")
	@Operation(summary = "Get All Entrant Types with Entrants")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<EntrantTypeListAllDto>> getEntrantTypesAll() {
		List<EntrantTypeListAllDto> entrantTypes = entrantTypeService.getEntrantTypesAll();
		return new ResponseEntity<List<EntrantTypeListAllDto>>(entrantTypes, HttpStatus.OK);
	}

	@GetMapping("entrantTypes/{entrantTypeId}")
	@Operation(summary = "Get One Entrant Type with Entrants")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<EntrantTypeDto> getEntrantTypeById(@PathVariable Integer entrantTypeId) {
		EntrantTypeDto entrantTypeDto = entrantTypeService.getEntrantTypeById(entrantTypeId);
		return new ResponseEntity<EntrantTypeDto>(entrantTypeDto, HttpStatus.OK);
	}
	
	@GetMapping("entrantTypes/{entrantTypeId}/entrantsAll")
	@Operation(summary = "Get One Entrant Type with Entrants")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<EntrantTypeListAllDto> getEntrantTypeAllEntrantsById(@PathVariable Integer entrantTypeId) {
		EntrantTypeListAllDto entrantTypeDto = entrantTypeService.getEntrantTypeAllEntrantById(entrantTypeId);
		return new ResponseEntity<EntrantTypeListAllDto>(entrantTypeDto, HttpStatus.OK);
	}

	@DeleteMapping("entrantTypes/{entrantTypeId}")
	@Operation(summary = "Delete Entrant Type")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteEntrantType(@PathVariable Integer entrantTypeId) {
		entrantTypeService.deleteEntrantType(entrantTypeId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Entrant Type deleted Successfully", true),
				HttpStatus.OK);
	}

	@PutMapping("entrantTypes/{entrantTypeId}")
	@Operation(summary = "Update Entrant Type")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<EntrantTypeDto> updateEntrantType(@RequestBody EntrantTypeDto entrantTypeDto,
			@PathVariable Integer entrantTypeId) {
		EntrantTypeDto updatedCategory = entrantTypeService.updateEntrantType(entrantTypeDto, entrantTypeId);
		return new ResponseEntity<EntrantTypeDto>(updatedCategory, HttpStatus.OK);
	}
}

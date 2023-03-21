package com.example.segurityapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.segurityapp.dto.EntrantDto;
import com.example.segurityapp.payloads.EntrantResponse;
import com.example.segurityapp.service.EntrantService;
import io.swagger.v3.oas.annotations.Operation;
import com.example.segurityapp.payloads.ApiResponse;
import com.example.segurityapp.config.AppConstants;

@RestController
@RequestMapping("/api/securityapp/")
@CrossOrigin
public class EntrantController {

	@Autowired
	EntrantService entrantService;

	// pagination and sorting
	@GetMapping("entrants/entrantsPagedStatic")
	@Operation(summary = "Get All Entrants Pagination")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<EntrantResponse> getAllEntrantsByPage(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SOTRT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		EntrantResponse entrantResponse = this.entrantService.getAllEntrantsByPage(pageNumber, pageSize, sortBy,
				sortDir);
		return new ResponseEntity<EntrantResponse>(entrantResponse, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@Operation(summary = "Save entrant with your entrantType")
	@PostMapping("entrantTypes/{id}/entrants")
	public ResponseEntity<?> createEntrant(@RequestBody @Valid EntrantDto entrantDto,
			@PathVariable Integer id, BindingResult result) {
		
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> errores = new HashMap<>();
		
		if(entrantService.findByDni(entrantDto.getDni()).isPresent()) {
			result.rejectValue("dni", "error.entrant","DNI is already registered");
		}
		
		if(result.hasErrors()) {
			
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), err.getDefaultMessage());
			});
			
			response.put("mensaje", "Correctly validate the resource information");
			response.put("error", errores);
			response.put("statuscode", "400");
			response.put("data", null);
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
			
		}
		
		EntrantDto savedEntrant = this.entrantService.createEntrat(entrantDto, id);
		return new ResponseEntity<EntrantDto>(savedEntrant, HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@Operation(summary = "Get All Entrants no pagination")
	@GetMapping("/entrants")
	public ResponseEntity<List<EntrantDto>> getAllEntrants() {
		List<EntrantDto> entrants = this.entrantService.getAllEntrants();
		return new ResponseEntity<List<EntrantDto>>(entrants, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@Operation(summary = "Search by DNI")
	@GetMapping("/entrants/searchDni/{keywords}")
	public ResponseEntity<List<EntrantDto>> searchEntrantByDni(@PathVariable("keywords") String keywords) {
		List<EntrantDto> result = this.entrantService.searchEntrantByDni(keywords);
		return new ResponseEntity<List<EntrantDto>>(result, HttpStatus.OK);
	}

	@GetMapping("/entrants/{id}")
	@Operation(summary = "Get One Entrant")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<EntrantDto> getEntrantById(@PathVariable Integer id) {
		EntrantDto entrant = this.entrantService.getEntrantById(id);
		return new ResponseEntity<EntrantDto>(entrant, HttpStatus.OK);
	}

	@DeleteMapping("/entrants/{id}")
	@Operation(summary = "Delete One Entrant")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteEntrant(@PathVariable Integer id) {
		entrantService.deleteEntrant(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Entrant Deleted Successfully", true), HttpStatus.OK);
	}

	@PutMapping("/entrants/{id}")
	@Operation(summary = "Update One Entrant")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<EntrantDto> updateEntrant(@RequestBody EntrantDto entrantDto, @PathVariable Integer id) {
		EntrantDto entrant = entrantService.updateEntrant(entrantDto, id);
		return new ResponseEntity<EntrantDto>(entrant, HttpStatus.OK);
	}
}

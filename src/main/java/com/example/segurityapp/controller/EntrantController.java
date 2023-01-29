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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.segurityapp.dto.EntrantDto;
import com.example.segurityapp.payloads.EntrantResponse;
import com.example.segurityapp.service.EntrantService;
import com.example.segurityapp.payloads.ApiResponse;
import com.example.segurityapp.config.AppConstants;

@RestController
@RequestMapping("/api/segurityapp/")
@CrossOrigin
public class EntrantController {

	@Autowired
	EntrantService entrantService;

//	@GetMapping("entrantsPaged")
//	public Iterable<Entrant> getAllEntrants(Pageable pageable ){
//		return entrantService.findAll(pageable);
//	}
//	
	// pagination and sorting
	@GetMapping("entrantsPagedStatic")
	public ResponseEntity<EntrantResponse> getAllEntrantsByPage(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SOTRT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {
		EntrantResponse entrantResponse = this.entrantService.getAllEntrantsByPage(pageNumber, pageSize, sortBy,
				sortDir);
		return new ResponseEntity<EntrantResponse>(entrantResponse, HttpStatus.OK);
	}

	@PostMapping("entrants/entrantType/{entrantTypeId}")
	public ResponseEntity<EntrantDto> createPost(@RequestBody EntrantDto entrantDto,
			@PathVariable Integer entrantTypeId) {
		EntrantDto savedEntrant = this.entrantService.createEntrat(entrantDto, entrantTypeId);
		return new ResponseEntity<EntrantDto>(savedEntrant, HttpStatus.CREATED);
	}

	@GetMapping("/entrants")
	public ResponseEntity<List<EntrantDto>> getAllPosts() {
		List<EntrantDto> entrants = this.entrantService.getAllEntrants();
		return new ResponseEntity<List<EntrantDto>>(entrants, HttpStatus.OK);
	}

	@GetMapping("/entrants/searchDni/{keywords}")
	public ResponseEntity<List<EntrantDto>> searchPostByTitle(@PathVariable("keywords") String keywords) {
		List<EntrantDto> result = this.entrantService.searchEntrantByDni(keywords);
		return new ResponseEntity<List<EntrantDto>>(result, HttpStatus.OK);
	}

	@GetMapping("/entrants/{entrantId}")
	public ResponseEntity<EntrantDto> getPostById(@PathVariable Integer entrantId) {
		EntrantDto entrant = this.entrantService.getEntrantById(entrantId);
		return new ResponseEntity<EntrantDto>(entrant, HttpStatus.OK);
	}

	@DeleteMapping("/entrants/{entrantId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer entrantId) {
		entrantService.deleteEntrant(entrantId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Entrant Deleted successfully", true), HttpStatus.OK);
	}

	@PutMapping("/entrants/{entrantId}")
	public ResponseEntity<EntrantDto> updatePost(@RequestBody EntrantDto entrantDto, @PathVariable Integer entrantId) {
		EntrantDto post = entrantService.updateEntrant(entrantDto, entrantId);
		return new ResponseEntity<EntrantDto>(post, HttpStatus.OK);
	}
}

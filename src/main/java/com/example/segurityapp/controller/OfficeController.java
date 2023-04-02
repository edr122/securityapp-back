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
import com.example.segurityapp.dto.OfficeDto;
import com.example.segurityapp.service.OfficeService;
import io.swagger.v3.oas.annotations.Operation;
import com.example.segurityapp.payloads.ApiResponse;

@RestController
@RequestMapping("/api/securityapp/")
@CrossOrigin
public class OfficeController {

	@Autowired
	OfficeService officeService;

	@PostMapping("offices")
	@Operation(summary = "Save Office")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<OfficeDto> saveOrUpdateOffice(@RequestBody @Valid OfficeDto officeDto) {
		OfficeDto savedOffice = officeService.createOffice(officeDto);
		return new ResponseEntity<OfficeDto>(savedOffice, HttpStatus.CREATED);
	}

	@GetMapping("offices")
	@Operation(summary = "Get All Offices")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<OfficeDto>> getAllOffices() {
		List<OfficeDto> offices = officeService.getAllOffices();
		return new ResponseEntity<List<OfficeDto>>(offices, HttpStatus.OK);
	}
	
	@GetMapping("offices/{id}")
	@Operation(summary = "Get One Office")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<OfficeDto> getOfficeById(@PathVariable Integer id) {
		OfficeDto officeDto = this.officeService.getOfficeById(id);
		return new ResponseEntity<OfficeDto>(officeDto, HttpStatus.OK);
	}

	@DeleteMapping("offices/{id}")
	@Operation(summary = "Delete Office")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> deleteOffice(@PathVariable Integer id) {
		officeService.deleteOffice(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Office deleted Successfully", true),
				HttpStatus.OK);
	}

	@PutMapping("offices/{id}")
	@Operation(summary = "Update Office")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<OfficeDto> updateOffice(@RequestBody OfficeDto officeDto,
			@PathVariable Integer id) {
		OfficeDto updatedOffice = officeService.updateOffice(officeDto, id);
		return new ResponseEntity<OfficeDto>(updatedOffice, HttpStatus.OK);
	}
}

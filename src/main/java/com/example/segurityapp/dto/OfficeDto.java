package com.example.segurityapp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class OfficeDto {

	private Integer id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "Name is required")
	@Length(min = 5, max = 100, message = "Name must have 5-100 characters")
	private String name;
	
	public OfficeDto() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package com.example.segurityapp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class EntrantTypeDto {

	private Integer entrantTypeId;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Description is required")
	@Length(min = 5, max = 512, message = "Description must have 5-100 characters")
	private String description;

	public EntrantTypeDto() {

	}

	public Integer getEntrantTypeId() {
		return entrantTypeId;
	}

	public void setEntrantTypeId(Integer entrantTypeId) {
		this.entrantTypeId = entrantTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.example.segurityapp.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class EntrantDto {

	private Integer id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "Dni is required")
	private String dni;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Last Name is required")
	private String lastName;

	private EntrantTypeDto entrantType;

	public EntrantDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public EntrantTypeDto getEntrantType() {
		return entrantType;
	}

	public void setEntrantType(EntrantTypeDto entrantType) {
		this.entrantType = entrantType;
	}

}

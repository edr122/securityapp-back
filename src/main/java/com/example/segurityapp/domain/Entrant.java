package com.example.segurityapp.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "entrants")
public class Entrant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "Dni is required")
	@Length(min = 8, max = 8, message = "Dni must have 8 characters")
	private String dni;

	@NotBlank(message = "Name is required")
	@Length(min = 3, max = 150, message = "Name is required must have 5-150 characters")
	private String name;

	@NotBlank(message = "Last Name is required")
	@Length(min = 3, max = 150, message = "Last Name is required must have 5-150 characters")
	private String lastName;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "entrantTypeId")
	@JsonProperty(access = Access.WRITE_ONLY)
	private EntrantType entrantType;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "rel_entrants_offices",
				joinColumns = @JoinColumn(name="entrant_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="office_id",referencedColumnName = "id"))
	private List<Office> offices;

	public Entrant() {

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

	public EntrantType getEntrantType() {
		return entrantType;
	}

	public void setEntrantType(EntrantType entrantType) {
		this.entrantType = entrantType;
	}

	public List<Office> getOffices() {
		return offices == null ? null : new ArrayList<>(offices);
	}

	public void setOffices(List<Office> offices) {
		if(offices == null){
			this.offices = null;
		} else {
			this.offices = Collections.unmodifiableList(offices);
		}
		
	}
}

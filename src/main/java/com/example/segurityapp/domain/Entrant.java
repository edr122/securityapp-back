package com.example.segurityapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrant")
public class Entrant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entraId;

	private String dni;
	private String name;
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "entrantTypeId")
	private EntrantType entrantType;

//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "typeentrant_id")
//    private TypeEntrant typeEntrant;

	public Entrant() {

	}

//	public TypeEntrant getTypeEntrant() {
//		return typeEntrant;
//	}
//
//	public void setTypeEntrant(TypeEntrant typeEntrant) {
//		this.typeEntrant = typeEntrant;
//	}

	public String getDni() {
		return dni;
	}

	public Integer getEntraId() {
		return entraId;
	}

	public void setEntraId(Integer entraId) {
		this.entraId = entraId;
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

}

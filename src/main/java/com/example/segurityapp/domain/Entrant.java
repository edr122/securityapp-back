package com.example.segurityapp.domain;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;

@Entity
public class Entrant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String dni;
	private String name;
	private String lastName;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name = "typeentrant_id")
//    private TypeEntrant typeEntrant;
	
	public Entrant() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
}

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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "offices")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "Name is required")
	@Length(min = 5, max = 100, message = "Name must have 5-100 characters")
	private String name;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(	name = "rel_entrants_offices",
				joinColumns = @JoinColumn(name="office_id",referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="entrant_id", referencedColumnName = "id"))
	private List<Entrant> entrants;

	public Office() {
	
	}
	
	

	public Office(Integer id,
			String name,
			List<Entrant> entrants) {
		this.id = id;
		this.name = name;
		this.entrants = entrants;
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

	public List<Entrant> getEntrants() {
		return entrants == null ? null : new ArrayList<>(entrants);
	}

	public void setEntrants(List<Entrant> entrants) {
		if(entrants == null){
			this.entrants = null;
		} else {
			this.entrants = Collections.unmodifiableList(entrants);
		}
		
	}
}

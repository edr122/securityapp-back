package com.example.segurityapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@ManyToMany(
			fetch = FetchType.LAZY,
			mappedBy = "offices")
	@JsonIgnore
	private Set<Entrant> entrants = new HashSet<>();
	
	public Office() {
	
	}
	
	public Set<Entrant> getEntrants() {
		return entrants;
	}

	public void setEntrants(Set<Entrant> entrants) {
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
}

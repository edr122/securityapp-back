package com.example.segurityapp.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "entrantType")
public class EntrantType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer entrantTypeId;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "Description is required")
	@Length(min = 5, max = 512, message = "Description must have 5-100 characters")
	private String description;

	@OneToMany(mappedBy = "entrantType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Entrant> entrants = new ArrayList<>();

	public EntrantType() {

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

	public List<Entrant> getEntrants() {
		return entrants;
	}

	public void setEntrants(List<Entrant> entrants) {
		this.entrants = entrants;
	}

}

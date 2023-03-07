package com.example.segurityapp.dto;

import java.util.Set;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import com.example.segurityapp.domain.Entrant;

public class EntrantTypeListAllDto {
	
	private Integer id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "Description is required")
	@Length(min = 5, max = 512, message = "Description must have 5-100 characters")
	private String description;

	private Set<Entrant> entrants;
	
	public EntrantTypeListAllDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Entrant> getEntrants() {
        return entrants;
    }
	
    public void setEntrants(Set<Entrant> entrants) {
        this.entrants = entrants;
    }
}

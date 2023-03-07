package com.example.segurityapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.segurityapp.domain.Entrant;

public interface EntrantRepository extends JpaRepository<Entrant, Integer> {
	
	List<Entrant> findByDniContaining(String dni);
	
	Optional<Entrant> findByDni(String dni);
	
}

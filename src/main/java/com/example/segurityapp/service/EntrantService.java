package com.example.segurityapp.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.segurityapp.domain.Entrant;

public interface EntrantService {
	
	public Iterable<Entrant> findAll();
	
	public Page<Entrant> findAll(Pageable pageable);
	
	public Entrant saveOrUpdateEntrant(Entrant entrant);
	
	public Optional<Entrant> findById(Integer id);
	
	public void delete(Integer id);

}

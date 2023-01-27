package com.example.segurityapp.service;

import java.util.Optional;
import com.example.segurityapp.domain.TypeEntrant;

public interface TypeEntrantService {
	
	public Iterable<TypeEntrant> findAll();
	
	public TypeEntrant saveOrUpdateEntrant(TypeEntrant typeEntrant);
	
	public Optional<TypeEntrant> findById(Integer id);
}

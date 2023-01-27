package com.example.segurityapp.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.segurityapp.domain.TypeEntrant;

public interface TypeEntrantService {
	
	public Iterable<TypeEntrant> findAll();
	
	public Page<TypeEntrant> findAll(Pageable pageable);
	
	public TypeEntrant saveOrUpdateEntrant(TypeEntrant typeEntrant);
	
	public Optional<TypeEntrant> findById(Integer id);
}

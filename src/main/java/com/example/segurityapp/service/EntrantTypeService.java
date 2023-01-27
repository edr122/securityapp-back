package com.example.segurityapp.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.segurityapp.domain.EntrantType;

public interface EntrantTypeService {
	
	public Iterable<EntrantType> findAll();
	
	public Page<EntrantType> findAll(Pageable pageable);
	
	public EntrantType saveOrUpdateEntrant(EntrantType typeEntrant);
	
	public Optional<EntrantType> findById(Integer id);
}

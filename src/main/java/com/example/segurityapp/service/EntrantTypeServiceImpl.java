package com.example.segurityapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.EntrantType;
import com.example.segurityapp.repository.EntrantTypeRepository;

@Service
public class EntrantTypeServiceImpl  implements EntrantTypeService{
	
	@Autowired
	private EntrantTypeRepository typeEntrantRepository;
	
	@Override
	public Iterable<EntrantType> findAll() {
		// TODO Auto-generated method stub
		return typeEntrantRepository.findAll();
	}
	
	@Override
	public Page<EntrantType> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return typeEntrantRepository.findAll(pageable);
	}
	
	@Override
	public EntrantType saveOrUpdateEntrant(EntrantType typeEntrant) {
		return typeEntrantRepository.save(typeEntrant);
	}
	
	@Override
	public Optional<EntrantType> findById(Integer id) {
		// TODO Auto-generated method stub
		return typeEntrantRepository.findById(id);
	}
}

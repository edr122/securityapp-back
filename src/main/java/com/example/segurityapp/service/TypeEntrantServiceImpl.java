package com.example.segurityapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.TypeEntrant;
import com.example.segurityapp.repository.TypeEntrantRepository;

@Service
public class TypeEntrantServiceImpl  implements TypeEntrantService{
	
	@Autowired
	private TypeEntrantRepository typeEntrantRepository;
	
	@Override
	public Iterable<TypeEntrant> findAll() {
		// TODO Auto-generated method stub
		return typeEntrantRepository.findAll();
	}
	
	@Override
	public TypeEntrant saveOrUpdateEntrant(TypeEntrant typeEntrant) {
		return typeEntrantRepository.save(typeEntrant);
	}
	
	@Override
	public Optional<TypeEntrant> findById(Integer id) {
		// TODO Auto-generated method stub
		return typeEntrantRepository.findById(id);
	}
}

package com.example.segurityapp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.Entrant;
import com.example.segurityapp.repository.EntrantRepository;



@Service
public class EntrantServiceImpl implements EntrantService{

	@Autowired
	private EntrantRepository entrantRepository;
	
	@Override
	public Iterable<Entrant> findAll() {
		// TODO Auto-generated method stub
		return entrantRepository.findAll();
	}
	
	@Override
	public Entrant saveOrUpdateEntrant(Entrant entrant) {
		if(entrant.getDni()==null || entrant.getDni() == "") {
			entrant.setDni("000000000");
		}
		return entrantRepository.save(entrant);
	}
	
	@Override
	public Optional<Entrant> findById(Integer id) {
		// TODO Auto-generated method stub
		return entrantRepository.findById(id);
	}
	
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Entrant entrant = entrantRepository.getById(id);
		entrantRepository.delete(entrant);
	}
}

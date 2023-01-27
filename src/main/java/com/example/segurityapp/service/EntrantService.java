package com.example.segurityapp.service;

import java.util.Optional;
import com.example.segurityapp.domain.Entrant;

public interface EntrantService {
	
	public Iterable<Entrant> findAll();
	
	public Entrant saveOrUpdateEntrant(Entrant entrant);
	
	public Optional<Entrant> findById(Integer id);
	
	public void delete(Integer id);

}

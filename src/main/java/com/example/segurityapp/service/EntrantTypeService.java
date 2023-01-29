package com.example.segurityapp.service;

import java.util.List;
import com.example.segurityapp.dto.EntrantTypeDto;

public interface EntrantTypeService {

//	public Iterable<EntrantType> findAll();
//	
//	public Page<EntrantType> findAll(Pageable pageable);

	public EntrantTypeDto createEntrant(EntrantTypeDto typeEntrant);

	List<EntrantTypeDto> getAllEntrantTypes();

	EntrantTypeDto getEntrantTypeById(Integer typeEntrantId);

	void deleteEntrantType(Integer typeEntrantId);

	EntrantTypeDto updateEntrantType(EntrantTypeDto entrantTypeDto, Integer typeEntrantId);
}

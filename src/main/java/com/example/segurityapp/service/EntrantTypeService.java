package com.example.segurityapp.service;

import java.util.List;
import com.example.segurityapp.dto.EntrantTypeDto;

public interface EntrantTypeService {

//	public Iterable<EntrantType> findAll();
//	
//	public Page<EntrantType> findAll(Pageable pageable);

	public EntrantTypeDto createEntrant(EntrantTypeDto entrantTypeDto);

	List<EntrantTypeDto> getAllEntrantTypes();

	EntrantTypeDto getEntrantTypeById(Integer id);

	void deleteEntrantType(Integer id);

	EntrantTypeDto updateEntrantType(EntrantTypeDto entrantTypeDto, Integer id);
}

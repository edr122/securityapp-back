package com.example.segurityapp.service;

import java.util.List;
import com.example.segurityapp.dto.EntrantTypeDto;
import com.example.segurityapp.dto.EntrantTypeListAllDto;

public interface EntrantTypeService {

	public EntrantTypeDto createEntrantType(EntrantTypeDto entrantTypeDto);

	List<EntrantTypeDto> getAllEntrantTypes();
	
	List<EntrantTypeListAllDto> getEntrantTypesAll();
	
	EntrantTypeDto getEntrantTypeById(Integer id);
	
	EntrantTypeListAllDto getEntrantTypeAllEntrantById(Integer id);

	void deleteEntrantType(Integer id);

	EntrantTypeDto updateEntrantType(EntrantTypeDto entrantTypeDto, Integer id);
}

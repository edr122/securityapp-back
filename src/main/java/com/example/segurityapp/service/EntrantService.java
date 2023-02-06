package com.example.segurityapp.service;

import java.util.List;
import com.example.segurityapp.dto.EntrantDto;
import com.example.segurityapp.payloads.EntrantResponse;

public interface EntrantService {

	EntrantDto createEntrat(EntrantDto entrantDto, Integer id);

	EntrantResponse getAllEntrantsByPage(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

//	public Page<Entrant> findAll(Pageable pageable);

	List<EntrantDto> getAllEntrants();

	List<EntrantDto> searchEntrantByDni(String keyword);

	EntrantDto getEntrantById(Integer id);

	void deleteEntrant(Integer id);

	EntrantDto updateEntrant(EntrantDto entrantDto, Integer id);

}

package com.example.segurityapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.Entrant;
import com.example.segurityapp.domain.EntrantType;
import com.example.segurityapp.dto.EntrantDto;
import com.example.segurityapp.payloads.EntrantResponse;
import com.example.segurityapp.repository.EntrantRepository;
import com.example.segurityapp.repository.EntrantTypeRepository;

@Service
public class EntrantServiceImpl implements EntrantService {

	@Autowired
	private EntrantRepository entrantRepository;

	@Autowired
	private EntrantTypeRepository entrantTypeRepository;

	@Autowired()
	private ModelMapper modelMapper;

//	@Override
//	public Page<Entrant> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return entrantRepository.findAll(pageable);
//	}

	@Override
	public EntrantResponse getAllEntrantsByPage(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

		Sort sort = null;
		if (sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		} else {
			sort = Sort.by(sortBy).descending();
		}

		Pageable pg = PageRequest.of(pageNumber, pageSize, sort);

		Page<Entrant> pageEntrants = this.entrantRepository.findAll(pg);
		List<Entrant> entrants = pageEntrants.getContent();

		// content
		List<EntrantDto> entrantDtos = entrants.stream().map((p) -> this.modelMapper.map(p, EntrantDto.class))
				.collect(Collectors.toList());

		EntrantResponse entrantResponse = new EntrantResponse();
		entrantResponse.setContent(entrantDtos);
		entrantResponse.setPageNumber(pageEntrants.getNumber());
		entrantResponse.setPageSize(pageEntrants.getSize());
		entrantResponse.setTotalElements(pageEntrants.getTotalElements());
		entrantResponse.setTotalPages(pageEntrants.getTotalPages());
		entrantResponse.setLastPage(pageEntrants.isLast());

		return entrantResponse;
	}

	@Override
	public EntrantDto createEntrat(EntrantDto entrantDto, Integer id) {

		EntrantType entrantType = this.entrantTypeRepository.findById(id)
				.orElseThrow(IllegalArgumentException::new);

		Entrant entrant = this.modelMapper.map(entrantDto, Entrant.class);

		entrant.setEntrantType(entrantType);

		Entrant saveEntrant = this.entrantRepository.save(entrant);

		return this.modelMapper.map(entrant, EntrantDto.class);
	}

	@Override
	public List<EntrantDto> getAllEntrants() {
		List<Entrant> entrants = this.entrantRepository.findAll();
		List<EntrantDto> entrantsDtos = entrants.stream()
				.map((entrandsmap) -> this.modelMapper.map(entrandsmap, EntrantDto.class)).collect(Collectors.toList());
		return entrantsDtos;
	}

	@Override
	public List<EntrantDto> searchEntrantByDni(String keyword) {
		List<Entrant> entrants = this.entrantRepository.findByDniContaining(keyword);
		List<EntrantDto> entrantsDtos = entrants.stream()
				.map((entrandsmap) -> this.modelMapper.map(entrandsmap, EntrantDto.class)).collect(Collectors.toList());
		return entrantsDtos;
	}

	@Override
	public EntrantDto getEntrantById(Integer id) {
		Entrant entrant = this.entrantRepository.findById(id).get();
		return this.modelMapper.map(entrant, EntrantDto.class);

	}

	@Override
	public void deleteEntrant(Integer entrantId) {
		Entrant entrant = this.entrantRepository.findById(entrantId).get();
		entrantRepository.delete(entrant);

	}

	@Override
	public EntrantDto updateEntrant(EntrantDto entrantDto, Integer entrantId) {

		Entrant entrant = this.entrantRepository.findById(entrantId).get();

		entrant.setName(entrantDto.getName());
		entrant.setLastName(entrantDto.getLastName());
		entrant.setDni(entrantDto.getDni());

		Entrant updatedEntrant = entrantRepository.save(entrant);

		return this.modelMapper.map(updatedEntrant, EntrantDto.class);
	}
}

package com.example.segurityapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.EntrantType;
import com.example.segurityapp.dto.EntrantTypeDto;
import com.example.segurityapp.repository.EntrantTypeRepository;

@Service
public class EntrantTypeServiceImpl implements EntrantTypeService {

	@Autowired
	private EntrantTypeRepository typeEntrantRepository;

	@Autowired
	private ModelMapper modelMapper;

//	@Override
//	public Iterable<EntrantType> findAll() {
//		// TODO Auto-generated method stub
//		return typeEntrantRepository.findAll();
//	}
//	
//	@Override
//	public Page<EntrantType> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return typeEntrantRepository.findAll(pageable);
//	}

	private EntrantType DtoToEntrantType(EntrantTypeDto entrantTypeDto) {
		EntrantType entrantType = modelMapper.map(entrantTypeDto, EntrantType.class);
		return entrantType;
	}

	private EntrantTypeDto EntrantTypeToDto(EntrantType entrantType) {
		EntrantTypeDto entrantTypeDto = modelMapper.map(entrantType, EntrantTypeDto.class);
		return entrantTypeDto;
	}

	// methods
	@Override
	public EntrantTypeDto createEntrantType(EntrantTypeDto entrantTypeDto) {
		EntrantType entrantType = this.DtoToEntrantType(entrantTypeDto);
		EntrantType savedEntrantType = typeEntrantRepository.save(entrantType);
		return this.EntrantTypeToDto(savedEntrantType);
	}

	@Override
	public List<EntrantTypeDto> getAllEntrantTypes() {
		List<EntrantType> entrantTypes = typeEntrantRepository.findAll();

		List<EntrantTypeDto> entrantTypeDto = entrantTypes.stream()
				.map(entrantTypesmap -> this.EntrantTypeToDto(entrantTypesmap)).collect(Collectors.toList());
		return entrantTypeDto;
	}

	@Override
	public EntrantTypeDto getEntrantTypeById(Integer typeEntrantId) {
		EntrantType entrantType = typeEntrantRepository.findById(typeEntrantId).get();
		return this.EntrantTypeToDto(entrantType);
	}

	@Override
	public void deleteEntrantType(Integer typeEntrantId) {
		EntrantType category = typeEntrantRepository.findById(typeEntrantId).get();
		typeEntrantRepository.delete(category);
	}

	@Override
	public EntrantTypeDto updateEntrantType(EntrantTypeDto entrantTypeDto, Integer typeEntrantId) {
		EntrantType entrantType = typeEntrantRepository.findById(typeEntrantId).get();

		entrantType.setDescription(entrantTypeDto.getDescription());

		EntrantType updatedEntrantType = typeEntrantRepository.save(entrantType);
		return this.EntrantTypeToDto(updatedEntrantType);
	}

}

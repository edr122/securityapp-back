package com.example.segurityapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.EntrantType;
import com.example.segurityapp.dto.EntrantTypeDto;
import com.example.segurityapp.dto.EntrantTypeListAllDto;
import com.example.segurityapp.repository.EntrantTypeRepository;

@Service
public class EntrantTypeServiceImpl implements EntrantTypeService {

	@Autowired
	private EntrantTypeRepository entrantTypeRepository;

	@Autowired
	private ModelMapper modelMapper;

	private EntrantType DtoToEntrantType(EntrantTypeDto entrantTypeDto) {
		EntrantType entrantType = modelMapper.map(entrantTypeDto, EntrantType.class);
		return entrantType;
	}

	private EntrantTypeDto EntrantTypeToDto(EntrantType entrantType) {
		EntrantTypeDto entrantTypeDto = modelMapper.map(entrantType, EntrantTypeDto.class);
		return entrantTypeDto;
	}
	
	private EntrantTypeListAllDto EntrantTypeToDtoAll(EntrantType entrantType) {
		EntrantTypeListAllDto entrantTypeDto = modelMapper.map(entrantType, EntrantTypeListAllDto.class);
		return entrantTypeDto;
	}

	// methods
	@Override
	public EntrantTypeDto createEntrantType(EntrantTypeDto entrantTypeDto) {
		EntrantType entrantType = this.DtoToEntrantType(entrantTypeDto);
		EntrantType savedEntrantType = entrantTypeRepository.save(entrantType);
		return this.EntrantTypeToDto(savedEntrantType);
	}

	@Override
	public List<EntrantTypeDto> getAllEntrantTypes() {
		List<EntrantType> entrantTypes = entrantTypeRepository.findAll();

		List<EntrantTypeDto> entrantTypeDto = entrantTypes.stream()
				.map(entrantTypesmap -> this.EntrantTypeToDto(entrantTypesmap)).collect(Collectors.toList());
		return entrantTypeDto;
	}
	
	@Override
	public List<EntrantTypeListAllDto> getEntrantTypesAll() {
		List<EntrantType> entrantTypes = entrantTypeRepository.findAll();

		List<EntrantTypeListAllDto> entrantTypeDto = entrantTypes.stream()
				.map(entrantTypesmap -> this.EntrantTypeToDtoAll(entrantTypesmap)).collect(Collectors.toList());
		return entrantTypeDto;
	}

	@Override
	public EntrantTypeDto getEntrantTypeById(Integer typeEntrantId) {
		EntrantType entrantType = entrantTypeRepository.findById(typeEntrantId).get();
		return this.EntrantTypeToDto(entrantType);
	}
	

	@Override
	public EntrantTypeListAllDto getEntrantTypeAllEntrantById(Integer typeEntrantId) {
		EntrantType entrantType = entrantTypeRepository.findById(typeEntrantId).get();
		return this.EntrantTypeToDtoAll(entrantType);
	}

	@Override
	public void deleteEntrantType(Integer typeEntrantId) {
		EntrantType category = entrantTypeRepository.findById(typeEntrantId).get();
		entrantTypeRepository.delete(category);
	}

	@Override
	public EntrantTypeDto updateEntrantType(EntrantTypeDto entrantTypeDto, Integer typeEntrantId) {
		EntrantType entrantType = entrantTypeRepository.findById(typeEntrantId).get();

		entrantType.setDescription(entrantTypeDto.getDescription());

		EntrantType updatedEntrantType = entrantTypeRepository.save(entrantType);
		return this.EntrantTypeToDto(updatedEntrantType);
	}

}

package com.example.segurityapp.service;

import java.util.List;
import com.example.segurityapp.dto.OfficeDto;

public interface OfficeService {

	public OfficeDto createOffice(OfficeDto officeDto);

	List<OfficeDto> getAllOffices();
		
	OfficeDto getOfficeById(Integer id);
	
	void deleteOffice(Integer id);

	OfficeDto updateOffice(OfficeDto officeDto, Integer id);
	
}

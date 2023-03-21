package com.example.segurityapp.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.segurityapp.domain.Office;
import com.example.segurityapp.dto.OfficeDto;
import com.example.segurityapp.repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService {

	@Autowired
	private OfficeRepository officeRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Office DtoToOffice(OfficeDto officeDto) {
		Office office = modelMapper.map(officeDto, Office.class);
		return office;
	}

	private OfficeDto OfficeToDto(Office office) {
		OfficeDto officeDto = modelMapper.map(office, OfficeDto.class);
		return officeDto;
	}

	@Override
	public OfficeDto createOffice(OfficeDto officeDto) {
		Office office = this.DtoToOffice(officeDto);
		Office savedOffice = officeRepository.save(office);
		return this.OfficeToDto(savedOffice);
	}

	@Override
	public List<OfficeDto> getAllOffices() {
		List<Office> offices = officeRepository.findAll();

		List<OfficeDto> officeDto = offices.stream()
				.map(officesmap -> this.OfficeToDto(officesmap)).collect(Collectors.toList());
		return officeDto;
	}
	
	@Override
	public OfficeDto getOfficeById(Integer officeId) {
		Office office = officeRepository.findById(officeId).get();
		return this.OfficeToDto(office);
	}
	
	@Override
	public void deleteOffice(Integer officeId) {
		Office office = officeRepository.findById(officeId).get();
		officeRepository.delete(office);
	}

	@Override
	public OfficeDto updateOffice(OfficeDto officeDto, Integer officeId) {
		Office office = officeRepository.findById(officeId).get();

		office.setName(officeDto.getName());

		Office updatedOffice = officeRepository.save(office);
		return this.OfficeToDto(updatedOffice);
	}

}

package com.example.segurityapp.repository;

import com.example.segurityapp.domain.Office;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
	
	Office findByName(String name);
	
}

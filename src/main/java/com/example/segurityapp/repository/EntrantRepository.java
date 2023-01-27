package com.example.segurityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.segurityapp.domain.Entrant;

@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer>{

}

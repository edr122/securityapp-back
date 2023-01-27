package com.example.segurityapp.repository;


import org.springframework.stereotype.Repository;
import com.example.segurityapp.domain.TypeEntrant;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TypeEntrantRepository extends JpaRepository<TypeEntrant, Integer>{

}

package com.example.segurityapp.repository;


import org.springframework.stereotype.Repository;
import com.example.segurityapp.domain.EntrantType;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EntrantTypeRepository extends JpaRepository<EntrantType, Integer>{

}

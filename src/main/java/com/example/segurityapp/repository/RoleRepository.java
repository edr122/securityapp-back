package com.example.segurityapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.segurityapp.domain.ERole;
import com.example.segurityapp.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(ERole name);

}

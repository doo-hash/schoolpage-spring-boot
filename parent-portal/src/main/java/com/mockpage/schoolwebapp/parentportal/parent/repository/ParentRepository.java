package com.mockpage.schoolwebapp.parentportal.parent.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;

public interface ParentRepository extends CrudRepository<Parent,Long>{

	public Optional<Parent> findById(Long id);
	
	public Optional<Parent> findBystudentId(String sid);

	public boolean existsBystudentId(String sid);
}
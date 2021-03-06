package com.mockpage.schoolwebapp.parentportal.parent.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;


@Service
public interface ParentService {

	public boolean existsById(Long id);
	public Optional<Parent> findById(Long id);
	public Optional<Parent> findBystudentId(String studentId);
	public boolean existsBystudentId(String studentId);
	public void deleteById(Long id);
	public void delete(Optional<Parent> parent);
	void save(Parent parent);
	void update(String sid,Parent parent);
	}

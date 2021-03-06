package com.mockpage.schoolwebapp.parentportal.parent.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;
import com.mockpage.schoolwebapp.parentportal.parent.repository.ParentRepository;

@Component
public class ParentServiceImpl implements ParentService{

	private final ParentRepository parentRepo;

	public ParentServiceImpl(ParentRepository parentRepo) {
		this.parentRepo = parentRepo;
	}
	@Override
	public boolean existsById(Long id) {

		boolean isPresent = parentRepo.existsById(id);
		return isPresent;
	}

	@Override
	public Optional<Parent> findById(Long id) {
		Optional<Parent> parent = parentRepo.findById(id);
		return parent;
	}

	@Override
	public boolean existsBystudentId(String studentId) {
		boolean isParent = parentRepo.existsBystudentId(studentId);
		return isParent;
	}

	@Override
	public void save(Parent parent) {
		parentRepo.save(parent);
	}

	@Override
	public void deleteById(Long id) {
		parentRepo.deleteById(id);
	}

	@Override
	public Optional<Parent> findBystudentId(String studentId) {
		Optional<Parent> parent = parentRepo.findBystudentId(studentId);
		return parent;
	}

	@Override
	public void delete(Optional<Parent> parent) {
		parentRepo.delete(parent.get());		
	}
	@Override
	public void update(String sid,Parent updateparent) {
		boolean parentPresent = parentRepo.findBystudentId(sid).isPresent();
		if(parentPresent) {
			Parent parent = parentRepo.findBystudentId(sid).get();
			parent.setFirstName(updateparent.getFirstName());
			parent.setLastName(updateparent.getLastName());
			parent.setEmail(updateparent.getEmail());
			parent.setStudentName(updateparent.getStudentName());
			parent.setStudentId(updateparent.getStudentId());
			parent.setPassword(updateparent.getPassword());
			
			parentRepo.save(parent);
		}
	}

}

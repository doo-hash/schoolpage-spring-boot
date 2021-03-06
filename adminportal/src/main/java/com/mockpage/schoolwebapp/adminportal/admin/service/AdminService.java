package com.mockpage.schoolwebapp.adminportal.admin.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;

@Service
public interface AdminService {

	public boolean existsById(Long id);
	public Optional<Admin> findById(Long id);
	public Optional<Admin> findByadminId(String adminId);
	public boolean existsByadminId(String adminId);
	public void deleteById(Long id);
	public void delete(Optional<Admin> admin);
	void save(Admin admin);
	void update(String adminId,Admin admin);
}

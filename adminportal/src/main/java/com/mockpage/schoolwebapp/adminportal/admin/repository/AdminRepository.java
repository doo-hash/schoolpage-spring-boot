package com.mockpage.schoolwebapp.adminportal.admin.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;

public interface AdminRepository extends CrudRepository<Admin,Long>{

	public Optional<Admin> findById(Long id);
	public boolean existsByadminId(String adminId);
	public Optional<Admin> findByAdminId(String adminId);
}
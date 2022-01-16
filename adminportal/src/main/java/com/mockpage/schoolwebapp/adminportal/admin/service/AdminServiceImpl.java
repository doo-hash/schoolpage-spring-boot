package com.mockpage.schoolwebapp.adminportal.admin.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;
import com.mockpage.schoolwebapp.adminportal.admin.repository.AdminRepository;

@Component
public class AdminServiceImpl implements AdminService{

	private final AdminRepository adminRepo;

	public AdminServiceImpl(AdminRepository adminRepo) {
		this.adminRepo = adminRepo;
	}
	@Override
	public boolean existsById(Long id) {

		boolean isPresent = adminRepo.existsById(id);
		return isPresent;
	}

	@Override
	public Optional<Admin> findById(Long id) {
		Optional<Admin> admin = adminRepo.findById(id);
		return admin;
	}

	@Override
	public boolean existsByadminId(String adminId) {
		boolean isAdmin = adminRepo.existsByadminId(adminId);
		return isAdmin;
	}

	@Override
	public void save(Admin admin) {
		adminRepo.save(admin);
	}

	@Override
	public void deleteById(Long id) {
		adminRepo.deleteById(id);
	}

	@Override
	public Optional<Admin> findByadminId(String adminId) {
		Optional<Admin> admin = adminRepo.findByAdminId(adminId);
		return admin;
	}

	@Override
	public void delete(Optional<Admin> admin) {
		adminRepo.delete(admin.get());		
	}
	@Override
	public void update(String id, Admin updateadmin) {
		boolean adminPresent = adminRepo.findByAdminId(id).isPresent();
		if(adminPresent) {
			Admin admin = adminRepo.findByAdminId(id).get();
			admin.setFirstName(updateadmin.getFirstName());
			admin.setLastName(updateadmin.getLastName());
			admin.setEmail(updateadmin.getEmail());
			admin.setDesignation(updateadmin.getDesignation());
			admin.setEducation(updateadmin.getEducation());
			admin.setAdminId(updateadmin.getAdminId());
			admin.setWork_experience(updateadmin.getWork_experience());
			admin.setPassword(updateadmin.getPassword());
			
			adminRepo.save(admin);
		}
	}

}

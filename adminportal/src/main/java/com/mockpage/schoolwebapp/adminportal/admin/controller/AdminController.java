package com.mockpage.schoolwebapp.adminportal.admin.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockpage.schoolwebapp.adminportal.admin.model.Admin;
import com.mockpage.schoolwebapp.adminportal.admin.service.AdminService;

@Controller
@RequestMapping("/home")
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@GetMapping("/admin")
	public String adminForm(Model model) {
		model.addAttribute("admin",new Admin());		
		return "admin_form";
	}
		
	@PostMapping("/admin/add_admin")
	public String adminSubmit(
			@Valid @ModelAttribute("admin") Admin admin,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "admin_form";
		}		
		model.addAttribute("admin",new Admin());
		model.addAttribute("message","You have successfully registered!!");
		adminservice.save(admin);

		return "admin_form";
	}

	
	@GetMapping("/login")
	public String adminLogin() {
		return "login";
	}

	@GetMapping("/admin_logout")
	public String adminLogout() {
		return "redirect:/home/login";
	}

	@PostMapping("/admin/auth_admin")
	public String adminLogin(Model model,
			@Valid @RequestParam String username, 
			@Valid @RequestParam String password) {		
		if(adminservice.existsByadminId(username)) {
			Optional<Admin> admin =	adminservice.findByadminId(username);
			if(password.equals(admin.get().getPassword())) {
				model.addAttribute(admin.get());
				String id = admin.get().getAdminId();
				return "redirect:/home/admin/admin_portal/"+id;
			}
			else {
				model.addAttribute("errormsg","password is wrong");
				return "login";
			}
		}
		else {
			model.addAttribute("usererr", "This account does not exist.");
			return "login";
		}
	}

	@PostMapping("/admin/update_admin/{id}")
	public String parentUpdate(@PathVariable String id,
			@Valid @ModelAttribute("admin") Admin admin,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "adminedit";
		}				
		if(adminservice.existsByadminId(admin.getAdminId())) {
			adminservice.update(id,admin);	
			model.addAttribute("admin", new Admin()); 
			model.addAttribute("message","Your account has been updated!!");
			return "admin_form";
		}		
		return null;
	}
	
	@GetMapping("/admin/admin_portal/{id}")
	public String adminPortal(@PathVariable String id,Model model) {
		Optional<Admin> admin =	adminservice.findByadminId(id);
		model.addAttribute("admin",admin.get());
		return "admin_portal";
	}

	
	@GetMapping("/admin/{adminId}/profile")
	public String adminProfile(@PathVariable String adminId,Model model) {
		Optional<Admin> admin = adminservice.findByadminId(adminId);
		model.addAttribute("admin", admin.get());
		return "profile";
	}

	@GetMapping("/admin/{adminId}/notifications")
	public String adminNotifications(@PathVariable String adminId,Model model) {
		Optional<Admin> admin = adminservice.findByadminId(adminId);
		model.addAttribute("admin", admin.get());
		return "notifications";
	}

	@GetMapping("/admin/{adminId}/settings")
	public String adminSettings(@PathVariable String adminId,Model model) {
		Optional<Admin> admin = adminservice.findByadminId(adminId);
		model.addAttribute("admin", admin.get());
		return "settings";
	}

	@GetMapping("/admin/{adminId}/edit")
	public String editadmin(@PathVariable String adminId,
			Model model) {
		Optional<Admin> admin = adminservice.findByadminId(adminId);
		model.addAttribute("admin",admin.get());
		return "adminedit";
	}
	
	@GetMapping("/admin/{adminId}/remove")
	public String deleteadmin(@PathVariable String adminId,
			Model model) {
		Optional<Admin> admin = adminservice.findByadminId(adminId);
		adminservice.delete(admin);
		model.addAttribute("deletemessage","This account has been deleted!!");
		model.addAttribute("message","Sign Up to know more.");
		return "admindelete";
	}
}

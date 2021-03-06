package com.mockpage.schoolwebapp.parentportal.parent.controller;

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

import com.mockpage.schoolwebapp.parentportal.parent.model.Parent;
import com.mockpage.schoolwebapp.parentportal.parent.service.ParentService;

@Controller
@RequestMapping("/home")
public class ParentController {

	@Autowired
	ParentService parentservice;
		
	@GetMapping("/parent")
	public String adminForm(Model model) {
		model.addAttribute("parent",new Parent());		
		return "parent_form";
	}
		
	@PostMapping("/parent/add_parent")
	public String parentSubmit(
			@Valid @ModelAttribute("parent") Parent parent,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "parent_form";
		}		
		
		model.addAttribute("parent", new Parent()); 
		model.addAttribute("message", "You have successfully registered!!");
		parentservice.save(parent);
		
		return "parent_form";
	}
	
	@GetMapping("/login")
	public String parentLogin() {
		return "login";
	}

	@GetMapping("/parent/parent_logout")
	public String parentLogout() {
		return "redirect:/home/login";
	}

	@PostMapping("/parent/auth_parent")
	public String parentLogin(Model model,
			@Valid @RequestParam String username, 
			@Valid @RequestParam String password) {		
		if(parentservice.existsBystudentId(username)) {
			Optional<Parent> parent =	parentservice.findBystudentId(username);
			if(password.equals(parent.get().getPassword())) {
				model.addAttribute(parent.get());
				String id = parent.get().getStudentId();
				return "redirect:/home/parent/parent_portal/"+id;
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
	
	@PostMapping("/parent/update_parent/{id}")
	public String parentUpdate(@PathVariable String id,
			@Valid @ModelAttribute("parent") Parent parent,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "parentedit";
		}				
		if(parentservice.existsBystudentId(parent.getStudentId())) {
			parentservice.update(id,parent);	
			model.addAttribute("parent", new Parent()); 
			model.addAttribute("message","Your account has been updated!!");
			return "parent_form";
		}		
		return null;
	}

	@GetMapping("/parent/parent_portal/{id}")
	public String parentPortal(@PathVariable String id,Model model) {
		Optional<Parent> parent =	parentservice.findBystudentId(id);
		model.addAttribute("parent",parent.get());
		return "parent_portal";
	}
	
	@GetMapping("/parent/{studentId}/profile")
	public String parentProfile(@PathVariable String studentId,Model model) {
		Optional<Parent> parent = parentservice.findBystudentId(studentId);
		model.addAttribute("parent", parent.get());
		return "profile";
	}

	@GetMapping("/parent/{studentId}/notifications")
	public String parentNotifications(@PathVariable String studentId,Model model) {
		Optional<Parent> parent = parentservice.findBystudentId(studentId);
		model.addAttribute("parent", parent.get());
		return "notifications";
	}

	@GetMapping("/parent/{studentId}/settings")
	public String parentSettings(@PathVariable String studentId,Model model) {
		Optional<Parent> parent = parentservice.findBystudentId(studentId);
		model.addAttribute("parent", parent.get());
		return "settings";
	}

	@GetMapping("/parent/{studentId}/edit")
	public String editparent(@PathVariable String studentId,
			Model model) {
		Optional<Parent> parent = parentservice.findBystudentId(studentId);
		model.addAttribute("parent", parent.get());
		return "parentedit";
	}
	
	@GetMapping("/parent/{studentId}/remove")
	public String deleteparent(@PathVariable String studentId,
			Model model) {
		Optional<Parent> parent = parentservice.findBystudentId(studentId);
		parentservice.delete(parent);
		model.addAttribute("deletemessage","This account has been deleted!!");
		model.addAttribute("message","Sign up to know more!!");
		model.addAttribute("parent",new Parent());
		return "parentdelete";
	}

}

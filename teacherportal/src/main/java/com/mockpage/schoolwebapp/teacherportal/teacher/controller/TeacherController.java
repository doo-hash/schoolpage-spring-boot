package com.mockpage.schoolwebapp.teacherportal.teacher.controller;

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

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;
import com.mockpage.schoolwebapp.teacherportal.teacher.service.TeacherService;

@Controller
@RequestMapping("/home")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherservice;
	
	@GetMapping("/teacher")
	public String teacherForm(Model model) {
		model.addAttribute("teacher",new Teacher());		
		return "teacher_form";
	}
		
	@PostMapping("/teacher/add_teacher")
	public String teacherSubmit(
			@Valid @ModelAttribute("teacher") Teacher teacher,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			return "teacher_form";
		}		
		model.addAttribute("teacher",new Teacher());
		model.addAttribute("message","You have successfully registered!!");
		teacherservice.save(teacher);

		return "teacher_form";
	}
	
	@GetMapping("/login")
	public String teacherLogin() {
		return "login";
	}

	@GetMapping("/teacher/teacher_logout")
	public String teacherLogout() {
		return "redirect:/home/login";
	}

	@PostMapping("/teacher/auth_teacher")
	public String teacherLogin(Model model,
			@Valid @RequestParam String username, 
			@Valid @RequestParam String password) {		
		if(teacherservice.existsByteacherId(username)) {
			Optional<Teacher> teacher =	teacherservice.findByteacherId(username);
			if(password.equals(teacher.get().getPassword())) {
				model.addAttribute(teacher.get());
				String id = teacher.get().getTeacherId();
				return "redirect:/home/teacher/teacher_portal/"+id;
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
	
	@GetMapping("/teacher/teacher_portal/{id}")
	public String teacherPortal(
			@PathVariable String id,
			Model model) {
		Optional<Teacher> teacher = teacherservice.findByteacherId(id);
		model.addAttribute("teacher",teacher.get());
		return "teacher_portal";
	}
	
	@GetMapping("/teacher/{teacherId}/profile")
	public String teacherProfile(@PathVariable String teacherId,Model model) {
		Optional<Teacher> teacher = teacherservice.findByteacherId(teacherId);
		model.addAttribute("teacher", teacher.get());
		return "profile";
	}

	@GetMapping("/teacher/{teacherId}/notifications")
	public String teacherNotifications(@PathVariable String teacherId,Model model) {
		Optional<Teacher> teacher = teacherservice.findByteacherId(teacherId);
		model.addAttribute("teacher", teacher.get());
		return "notifications";
	}

	@GetMapping("/teacher/{teacherId}/settings")
	public String teacherSettings(@PathVariable String teacherId,Model model) {
		Optional<Teacher> teacher = teacherservice.findByteacherId(teacherId);
		model.addAttribute("teacher", teacher.get());
		return "settings";
	}

	
	@GetMapping("/teacher/{teacherId}/edit")
	public String editteacher(@PathVariable String teacherId,
			Model model) {
		Optional<Teacher> teacher = teacherservice.findByteacherId(teacherId);
		model.addAttribute("teacher",teacher.get());
		return "teacheredit";
	}
	
	
	@PostMapping("/teacher/update_teacher/{id}")
	public String teacherUpdate(@PathVariable String id,
			@Valid @ModelAttribute("teacher") Teacher teacher,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "teacheredit";
		}
		if(teacherservice.existsByteacherId(teacher.getTeacherId())) {
			teacherservice.update(id, teacher);
			model.addAttribute("teacher", new Teacher());
			model.addAttribute("message","Your account has been updated!!");
			return "teacher_form";
		}

		return null;
	}


	@GetMapping("/teacher/{teacherId}/remove")
	public String deleteteacher(@PathVariable String teacherId,
			Model model) {
		Optional<Teacher> teacher = teacherservice.findByteacherId(teacherId);
		teacherservice.delete(teacher);
		model.addAttribute("message","Sign Up to know more.");
		model.addAttribute("deletemessage","This account has been deleted!!");
		model.addAttribute("teacher",new Teacher());
		return "teacherdelete";
	}

}

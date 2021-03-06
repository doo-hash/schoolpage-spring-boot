package com.mockpage.schoolwebapp.teacherportal.teacher.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;
import com.mockpage.schoolwebapp.teacherportal.teacher.repository.TeacherRepository;

@Component
public class TeacherServiceImpl implements TeacherService {
	
	private final TeacherRepository teacherRepo;

	public TeacherServiceImpl(TeacherRepository teacherRepo) {
		this.teacherRepo = teacherRepo;
	}
	@Override
	public boolean existsById(Long id) {

		boolean isPresent = teacherRepo.existsById(id);
		return isPresent;
	}

	@Override
	public Optional<Teacher> findById(Long id) {
		Optional<Teacher> teacher = teacherRepo.findById(id);
		return teacher;
	}

	@Override
	public boolean existsByteacherId(String teacherId) {
		boolean isTeacher = teacherRepo.existsByteacherId(teacherId);
		return isTeacher;
	}

	@Override
	public void save(Teacher teacher) {
		teacherRepo.save(teacher);
	}

	@Override
	public void deleteById(Long id) {
		teacherRepo.deleteById(id);
	}

	@Override
	public Optional<Teacher> findByteacherId(String teacherId) {
		Optional<Teacher> teacher = teacherRepo.findByteacherId(teacherId);
		return teacher;
	}

	@Override
	public void delete(Optional<Teacher> teacher) {
		teacherRepo.delete(teacher.get());		
	}
	@Override
	public void update(String teacherId, Teacher updateteacher) {
		boolean teacherPresent = teacherRepo.existsByteacherId(teacherId);
		if(teacherPresent) {
			Teacher teacher = teacherRepo.findByteacherId(teacherId).get();
			teacher.setFirstName(updateteacher.getFirstName());
			teacher.setLastName(updateteacher.getLastName());
			teacher.setDesignation(updateteacher.getDesignation());
			teacher.setEducation(updateteacher.getEducation());
			teacher.setEmail(updateteacher.getEmail());
			teacher.setPassword(updateteacher.getPassword());
			teacher.setTeacherId(updateteacher.getTeacherId());
			teacher.setWork_experience(updateteacher.getWork_experience());
			
			teacherRepo.save(teacher);
		}
	}

}

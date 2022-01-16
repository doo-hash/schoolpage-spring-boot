package com.mockpage.schoolwebapp.teacherportal.teacher.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;


public interface TeacherRepository extends CrudRepository<Teacher,Long>{

	public Optional<Teacher> findById(Long id);
	
	public Optional<Teacher> findByteacherId(String teacherId);

	public boolean existsByteacherId(String teacherId);
}
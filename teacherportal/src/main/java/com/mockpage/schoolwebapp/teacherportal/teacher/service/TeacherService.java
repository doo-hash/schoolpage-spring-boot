package com.mockpage.schoolwebapp.teacherportal.teacher.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.teacherportal.teacher.model.Teacher;

@Service
public interface TeacherService {
	public boolean existsById(Long id);
	public Optional<Teacher> findById(Long id);
	public Optional<Teacher> findByteacherId(String teacherId);
	public boolean existsByteacherId(String teacherId);
	public void deleteById(Long id);
	public void delete(Optional<Teacher> teacher);
	void save(Teacher teacher);
	void update(String teacherId,Teacher teacher);
}

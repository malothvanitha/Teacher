package com.edubridge.app4.service;

import java.util.List;

import com.edubridge.app4.model.Teacher;

public interface TeacherServiceI {
	void addTeacher(Teacher teacher);
	List<Teacher> getAllteachers();	
	Teacher getTeacherById(Integer id);
	void updateTeacher(Teacher teacher);
	void deleteTeacher(Integer id);
	void deleteAllTeachers();
}


package com.edubridge.app4.dao;


	
	import java.util.List;

	import com.edubridge.app4.model.Teacher;

	public interface TeacherDaoI {
		void addTeacher(Teacher teacher);
		List<Teacher> getAllTeachers();	
		Teacher getTeacherById(Integer id);
		void updateTeacher(Teacher teacher);
		void deleteTeacher(Integer id);
		void deleteAllTeachers();
	}




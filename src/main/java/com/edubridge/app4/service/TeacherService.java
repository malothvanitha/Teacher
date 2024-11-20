package com.edubridge.app4.service;

import java.util.List;

import com.edubridge.app4.dao.TeacherDao;
import com.edubridge.app4.model.Teacher;

public  class TeacherService implements TeacherServiceI {
    private TeacherDao dao;
    
    // Constructor initializes the TeacherDao
    public TeacherService() {
        dao = new TeacherDao();  // Initializing TeacherDao
    }
    
    @Override
    public void addTeacher(Teacher teacher) {
        dao.addTeacher(teacher);  // Add teacher to the database
    }

    public List<Teacher> getAllTeachers() {
        return dao.getAllTeachers();  // Retrieve all teachers
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return dao.getTeacherById(id);  // Get a teacher by their ID
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        dao.updateTeacher(teacher);  // Update teacher information
    }

    @Override
    public void deleteTeacher(Integer id) {
        dao.deleteTeacher(id);  // Delete a teacher by their ID
    }

    @Override
    public void deleteAllTeachers() {
        dao.deleteAllTeachers();  // Delete all teachers
    }

	@Override
	public List<Teacher> getAllteachers() {
		// TODO Auto-generated method stub
		return null;
	}
}

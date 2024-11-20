package com.edubridge.app4.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.edubridge.app4.model.Teacher;
import com.edubridge.app4.utils.HibernateUtils;

public class TeacherDao implements TeacherDaoI {

	@Override
	public void addTeacher(Teacher teacher) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.persist(teacher);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("new teacher addedd!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> teachers = new ArrayList<Teacher>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			String hql = "from Teacher";
			Query query = session.createQuery(hql, Teacher.class);
			teachers = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}

	@Override
	public Teacher getTeacherById(Integer id) {
		Teacher teacher = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			teacher = session.get(Teacher.class, id);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return teacher;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Transaction tx = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			session.merge(teacher);
			tx = session.beginTransaction();
			tx.commit();
			System.out.println("teacher is updated!");

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTeacher(Integer id) {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();

			Teacher teacher = session.get(Teacher.class, id);

			if (teacher != null) {
				session.remove(teacher);
				tx.commit();
				System.out.println("teacher is deleted!");
			} else {
				System.out.println("no teacher found!");
			}
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAllTeachers() {
		Transaction tx = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			String hql = "delete from Teacher";
			Query query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("All teachers are deleted");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}


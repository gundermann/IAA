package de.nordakademie.roommgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import de.nordakademie.roommgmt.HibernateUtil;
import de.nordakademie.roommgmt.model.Course;

public class CourseDAO {

	public Course saveCourse(Course course) throws CourseAlreadyExistsException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().save(course);
		} catch (ConstraintViolationException exception) {
			throw new CourseAlreadyExistsException();
		}
		return course;
	}

	@SuppressWarnings("unchecked")
	public List<Course> listCourses() {
		List<Course> courses = new ArrayList<Course>();
		courses.addAll(HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("FROM Course").list());
		return courses;
	}

	public Course loadCourse(Long courseId) {
		Course course;
		course = (Course) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(Course.class, courseId);
		if (course == null)
			throw new CourseNotFoundException();
		return course;
	}

	public void deleteCourse(long courseId) {
		Course course = loadCourse(courseId);
		HibernateUtil.getSessionFactory().getCurrentSession()
				.delete(course);
		if (course == null)
			throw new CourseNotFoundException();
	}

	public Course loadCourseByNumber(long courseNumber) {
		Course course;
		course = (Course) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(Course.class, courseNumber);
		if (course == null)
			throw new CourseNotFoundException();
		return course;
	}
}

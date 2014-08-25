package de.nordakademie.roommgmt.dao;

import org.hibernate.exception.ConstraintViolationException;

import de.nordakademie.roommgmt.HibernateUtil;
import de.nordakademie.roommgmt.model.Lecture;

public class LectureDAO {

	public Lecture saveLecture(Lecture lecture)
			throws CourseAlreadyExistsException {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().save(lecture);
		} catch (ConstraintViolationException exception) {
			throw new CourseAlreadyExistsException();
		}
		return lecture;
	}
	public Lecture loadLecture(Long lectureId) {
		Lecture lecture;
		lecture = (Lecture) HibernateUtil.getSessionFactory().getCurrentSession()
				.get(Lecture.class, lectureId);
		if (lecture == null)
			throw new CourseNotFoundException();
		return lecture;
	}

}

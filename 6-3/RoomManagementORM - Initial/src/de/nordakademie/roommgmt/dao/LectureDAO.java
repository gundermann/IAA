package de.nordakademie.roommgmt.dao;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import de.nordakademie.roommgmt.HibernateUtil;
import de.nordakademie.roommgmt.model.Course;
import de.nordakademie.roommgmt.model.Lecture;
import de.nordakademie.roommgmt.model.Room;

public class LectureDAO {

	public Lecture saveLecture(Lecture lecture)
			throws CourseAlreadyExistsException {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Course course = (Course) session.load(Course.class, lecture.getCourse().getId());
			course.associateLecture(lecture);
			
			Room room = (Room) session.load(Room.class, lecture.getRoom().getId());
			room.assoziateLecture(lecture);
			session.save(lecture);
			
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

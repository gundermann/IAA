package de.nordakademie.roommgmt.action;

import java.util.List;

import de.nordakademie.roommgmt.dao.CourseDAO;
import de.nordakademie.roommgmt.model.Course;
import de.nordakademie.roommgmt.model.Room;

/**
 * Action to list all existing {@link Room} entities.
 */
public class ListCourseAction extends DatabaseAction {

	/** {@inheritDoc} */
	@Override
	public String getLabel() {
		return "Alle vorhandenen Kurse auflisten!";
	}

	/** {@inheritDoc} */
	@Override
	public void execute() throws Exception {
		CourseDAO courseDAO = getCourseDAO();
		List<Course> courses = courseDAO.listCourses();
		for (Course course : courses) {
			System.out.printf("Kurs mit ID %1$d:%n", course.getId());
			System.out.printf(" - Kurs %s-%d; Fach: %s, Dozent: %s; id %d%n",
					course.getTitle(), course.getNumber(),
					course.getFieldOfStudy(), course.getLecturer(), course.getId());
			System.out.println("---------------------------");
		}
	}

}

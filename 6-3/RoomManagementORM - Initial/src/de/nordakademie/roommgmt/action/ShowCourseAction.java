package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Course;

public class ShowCourseAction extends DatabaseAction {

	@Override
	public String getLabel() {
		return "Kurs anzeigen!";
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie die Nummer des Kurses ein!");
		Long number = ConsoleUtil.readLong();
		Course course = getCourseDAO().loadCourse(number);

		System.out.printf(" - Kurs %s-%d; Fach: %s, Dozent: %s; id %d%n",
				course.getTitle(), course.getNumber(),
				course.getFieldOfStudy(), course.getLecturer(), course.getId());

	}

}

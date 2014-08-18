package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Course;

public class CreateCourseAction extends DatabaseAction {

	@Override
	public String getLabel() {
		return "Neuen Kurs erstellen";
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie den Titel an!");
		String title = ConsoleUtil.readString();
		System.out.println("Geben Sie die Nummer des Kurses ein!");
		int number = ConsoleUtil.readInt();
		System.out.println("Geben Sie den Namen des Dozenten an!");
		String lecturer = ConsoleUtil.readString();
		System.out.println("Geben Sie das Fach an!");
		String fieldOfStudy = ConsoleUtil.readString();

		Course course = new Course();
		course.setTitle(title);
		course.setLecturer(lecturer);
		course.setNumber(number);
		course.setFieldOfStudy(fieldOfStudy);

		course = getCourseDAO().saveCourse(course);
		System.out
				.printf("Der Kurs %s mit der Nummer %d wurde unter der id %d gespeichert",
						course.getTitle(), course.getNumber(), course.getId());

	}

}

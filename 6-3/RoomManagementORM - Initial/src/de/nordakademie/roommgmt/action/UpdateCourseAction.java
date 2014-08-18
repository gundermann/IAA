package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Course;

public class UpdateCourseAction extends DatabaseAction {

	@Override
	public String getLabel() {
		return "Kurs ändern!";
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie eine Kurs ID an!");
		long courseId = ConsoleUtil.readLong();
		System.out.println("Geben Sie den neuen Dozenten an!");
		String lecturer = ConsoleUtil.readString();
		System.out.println("Geben Sie den neue Namen an!");
		String title = ConsoleUtil.readString();
		System.out.println("Geben Sie das neue Fachgebiet an!");
		String fieldOfStudy = ConsoleUtil.readString();
		
		// update and save room
		Course course = getCourseDAO().loadCourse(courseId);
		course.setLecturer(lecturer);
		course.setTitle(title);
		course.setFieldOfStudy(fieldOfStudy);
		getCourseDAO().saveCourse(course);

		System.out.printf("Der Kurs mit der ID %1$d wurde aktualisiert!%n",
				courseId);

	}

}

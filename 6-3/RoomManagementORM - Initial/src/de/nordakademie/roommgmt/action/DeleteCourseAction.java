package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Course;

public class DeleteCourseAction extends DatabaseAction {

	@Override
	public String getLabel() {
		return "Neuen Kurs erstellen";
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie die Kurs ID an!");
		long courseId = ConsoleUtil.readLong();
		getCourseDAO().deleteCourse(courseId);
		System.out.printf("Der Kurs mit der ID %1$d wurde gelöscht!%n", courseId);
	}

}

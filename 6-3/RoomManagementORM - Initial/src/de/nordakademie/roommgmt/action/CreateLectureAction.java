package de.nordakademie.roommgmt.action;

import java.util.Date;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Course;
import de.nordakademie.roommgmt.model.Lecture;

public class CreateLectureAction extends DatabaseAction {

	@Override
	public String getLabel() {
		return "Create Lecture";
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Startzeit:");
		Date beginDate = ConsoleUtil.readDate();

		System.out.println("Endzeit:");
		Date endDate = ConsoleUtil.readDate();

		Course course = null;
		while (course == null) {
			long courseId = ConsoleUtil.readLong();
			course = getCourseDAO().loadCourse(courseId);
		}

		Lecture lecture = new Lecture();
		lecture.setBeginDate(beginDate);
		lecture.setEndDate(endDate);
		lecture.setCourse(course);

		lecture.setId(getLectureDAO().saveLecture(lecture).getId());

		System.out.printf(
				"Lecture with ID %d saved. Begin: %d End: %d Course: %s",
				lecture.getId(), lecture.getBeginDate(), lecture.getEndDate(),
				lecture.getCourse().getTitle());

	}

}

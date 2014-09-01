package de.nordakademie.roommgmt.action;

import java.text.DateFormat;
import java.util.Date;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Course;
import de.nordakademie.roommgmt.model.Lecture;
import de.nordakademie.roommgmt.model.Room;

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
			System.out.println("Geben Sie die Kursnummer ein:");
			long courseId = ConsoleUtil.readLong();
			course = getCourseDAO().loadCourse(courseId);
		}
		
		Room room = null;
		while (room == null) {
			System.out.println("Geben Sie die Kursnummer ein:");
			long roomId = ConsoleUtil.readLong();
			room = getRoomDAO().loadRoom(roomId);
		}

		Lecture lecture = new Lecture();
		lecture.setBeginDate(beginDate);
		lecture.setEndDate(endDate);
		lecture.setCourse(course);
		lecture.setRoom(room);

		lecture.setId(getLectureDAO().saveLecture(lecture).getId());

		System.out.printf(
				"Lecture with ID %d saved. Begin: %s End: %s Course: %s",
				lecture.getId(), DateFormat.getDateTimeInstance().format(lecture.getBeginDate()), DateFormat.getDateTimeInstance().format(lecture.getEndDate()),
				lecture.getCourse().getTitle());

	}

}

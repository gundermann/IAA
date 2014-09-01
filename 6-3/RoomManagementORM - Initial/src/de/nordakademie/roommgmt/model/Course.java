package de.nordakademie.roommgmt.model;

import java.util.Set;

public class Course {

	private Long id;
	private String fieldOfStudy;
	private int number;
	private String lecturer;
	private String title;
	private Set<Lecture> lectures;

	public Course() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

	public void associateLecture(Lecture lecture) {
		if (lecture == null) {
			throw new IllegalArgumentException();
		}
		if (lecture.getCourse() == null) {
			lecture.setCourse(this);
			
		}
		else if(!lecture.getCourse().equals(this)) {
			lecture.getCourse().getLectures().remove(lecture);
			lecture.setCourse(this);
		}
		if(!lectures.contains(lecture)){
			lectures.add(lecture);
		}
	}

}

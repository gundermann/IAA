package de.nordakademie.roommgmt.dao;

public class CourseAlreadyExistsException extends Exception {
	/** the serial version uid. */
	private static final long serialVersionUID = -6080027662783731790L;

	/**
	 * Constructor for {@link RoomAlreadyExistsException}.
	 */
	public CourseAlreadyExistsException() {
		super("Dieser Kurs ist bereitz vorhanden!");
	}

}

/**
 * 
 */
package de.nordakademie.roommgmt.dao;

/**
 * Exception that indicates a missing room.
 */
public class CourseNotFoundException extends RuntimeException {

	/** the serial version uid. */
	private static final long serialVersionUID = -3081260136139364750L;

	/**
	 * Constructor for {@link CourseNotFoundException}.
	 */
	public CourseNotFoundException() {
		super("Der Kurs konnte nicht gefunden werden!");
	}
}

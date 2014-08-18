package de.nordakademie.roommgmt.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

import de.nordakademie.roommgmt.HibernateUtil;
import de.nordakademie.roommgmt.model.Room;

/**
 * The room dao that manages data access.
 */
public class RoomDAO {

	/**
	 * List all rooms currently stored in the database.
	 * 
	 * @return a list of room entities. If no room was found an empty list is
	 *         returned.
	 */
	@SuppressWarnings("unchecked")
	public List<Room> listRooms() {
		Session currentSession = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		List<Room> rooms = currentSession.createQuery("from Room").list();
		return rooms;
	}

	/**
	 * Creates a new room in the database.
	 * 
	 * @param room
	 * 			The room to save
	 * @throws RoomAlreadyExistsException
	 *             if the room already exists in the database.
	 */
	public Room saveRoom(Room room) {
		try {
			HibernateUtil.getSessionFactory().getCurrentSession().save(room);
		} catch (ConstraintViolationException exception) {
			throw new RoomAlreadyExistsException();
		}
		return room;
	}

	/**
	 * Returns the room identified by the given id.
	 * 
	 * @param roomId
	 *            The identifier.
	 * @return the found entity.
	 * @throws RoomNotFoundException
	 *             if no room could be found for the given id.
	 */
	public Room loadRoom(Long roomId) {
		// get session
		Session currentSession = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		Room room = (Room) currentSession.get(Room.class, roomId);
		if (room == null) {
			throw new RoomNotFoundException();
		}
		return room;
	}

	/**
	 * Deletes the room with the given id.
	 * 
	 * @param roomId
	 *            The identifier.
	 * @throws RoomNotFoundException
	 *             if no room could be fount for the given id.
	 * @throws RoomInUseException
	 *             if the room is still in use by lectures.
	 */
	public void deleteRoom(Long roomId) {
		Room room = loadRoom(roomId);
		HibernateUtil.getSessionFactory().getCurrentSession().delete(room);
	}
}

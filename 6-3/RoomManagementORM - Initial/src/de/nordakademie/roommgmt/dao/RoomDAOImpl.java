package de.nordakademie.roommgmt.dao;

import java.util.List;

import org.hibernate.Session;

import de.nordakademie.roommgmt.HibernateUtil;
import de.nordakademie.roommgmt.model.Room;

public class RoomDAOImpl {

	public Room saveRoom(Room room) {
		Session currentSession = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		currentSession.beginTransaction();
		currentSession.save(room);
		currentSession.getTransaction().commit();
		return room;
	}

	@SuppressWarnings("unchecked")
	public List<Room> listAllRooms() {
		Session currentSession = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		currentSession.beginTransaction();
		List<Room> roomList = currentSession.createQuery("FROM Room").list();
		currentSession.getTransaction().commit();
		return roomList;

	}
}

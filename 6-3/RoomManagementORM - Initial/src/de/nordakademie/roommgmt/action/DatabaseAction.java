package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.dao.RoomDAO;
import de.nordakademie.roommgmt.dao.DAOFactory;

/**
 * Action that is provided with a transaction.
 */
public abstract class DatabaseAction extends Action {

	/**
	 * Returns the {@link RoomDAO} instance.
	 * 
	 * @return an instance of the service.
	 */
	public RoomDAO getRoomDAO() {
		return DAOFactory.createRoomDAO();
	}
}

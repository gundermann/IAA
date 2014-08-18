package de.nordakademie.roommgmt.dao;

/**
 * The dao factory. This class cannot be instantiated but provides static
 * methods to create (singleton) instances of the daos.
 * 
 * @author Stefan Reichert
 */
public final class DAOFactory {

	/**
	 * Hidden default constructor.
	 */
	private DAOFactory() {
		// Do nothing
	}
	
	public static RoomDAOImpl createRoomDAO(){
		return new RoomDAOImpl();
	}
}

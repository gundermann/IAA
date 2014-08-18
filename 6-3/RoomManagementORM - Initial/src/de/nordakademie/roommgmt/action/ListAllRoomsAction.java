package de.nordakademie.roommgmt.action;

import java.util.List;

import de.nordakademie.roommgmt.dao.DAOFactory;
import de.nordakademie.roommgmt.model.Room;

public class ListAllRoomsAction extends Action {

	@Override
	public String getLabel() {
		return "Alle Räume anzeigen";
	}

	@Override
	public void execute() throws Exception {
		List<Room> roomSet = DAOFactory.createRoomDAO().listAllRooms();
		System.out.println("Gespeicherte Räume:");
		for (Room room : roomSet) {
			System.out.printf(" - Raum %s-%d; Sitze: %d, Beamer vorhanden: %b; ID: %d%n",
					room.getBuilding(), room.getRoomNumber(),
					room.getSeatCount(), room.isBeamerPresent(), room.getId());
		}
	}

}

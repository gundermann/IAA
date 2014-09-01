package de.nordakademie.roommgmt.action;

import java.text.DateFormat;
import java.util.List;

import de.nordakademie.roommgmt.dao.RoomDAO;
import de.nordakademie.roommgmt.model.Lecture;
import de.nordakademie.roommgmt.model.Room;

/**
 * Action to list all existing {@link Room} entities.
 */
public class ListRoomsAction extends DatabaseAction {

	/** {@inheritDoc} */
	@Override
	public String getLabel() {
		return "Alle vorhandenen Räume auflisten!";
	}

	/** {@inheritDoc} */
	@Override
	public void execute() throws Exception {
		RoomDAO roomDAO = getRoomDAO();
		List<Room> rooms = roomDAO.listRooms();
		for (Room room : rooms) {
			System.out.printf("Raum mit ID %1$d:%n", room.getId());
			System.out
					.printf(" - Gebäude: %1$s, Raumnummer: %2$d, Plätze: %3$d, Beamer [%4$b]%n",
							room.getBuilding(), room.getRoomNumber(),
							room.getSeats(), room.isBeamer());
			
			for (Lecture lecture : room.getLectures()) {
				System.out.printf(" - * Veranstaltung am %s", DateFormat
						.getTimeInstance().format(lecture.getBeginDate()));
			}
			System.out.println("---------------------------");
		}
	}

}

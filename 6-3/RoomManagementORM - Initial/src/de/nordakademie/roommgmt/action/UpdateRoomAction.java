package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Room;

/**
 * Action to update a {@link Room}.
 */
public class UpdateRoomAction extends DatabaseAction {

	/** {@inheritDoc} */
	@Override
	public String getLabel() {
		return "Einen Raum aktualisieren!";
	}

	/** {@inheritDoc} */
	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie eine Raum ID an!");
		long roomId = ConsoleUtil.readLong();
		System.out.println("Geben Sie die neue Anzahl Pl�tze an!");
		int seats = ConsoleUtil.readInt();
		System.out.println("Hat der Raum einen Beamer?");
		boolean beamer = ConsoleUtil.readBoolean();
		
		// update and save room
		Room room = getRoomDAO().loadRoom(roomId);
		room.setSeats(seats);
		room.setBeamer(beamer);
		getRoomDAO().saveRoom(room);

		System.out.printf("Der Raum mit der ID %1$d wurde aktualisiert!%n",
				roomId);
	}

}

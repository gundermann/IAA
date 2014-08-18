package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.model.Room;

/**
 * Action to delete a {@link Room}.
 */
public class DeleteRoomAction extends DatabaseAction {

	/** {@inheritDoc} */
	@Override
	public String getLabel() {
		return "Einen Raum löschen!";
	}

	/** {@inheritDoc} */
	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie die Raum ID an!");
		long roomId = ConsoleUtil.readLong();
		getRoomDAO().deleteRoom(roomId);
		System.out.printf("Der Raum mit der ID %1$d wurde gelöscht!%n", roomId);
	}

}

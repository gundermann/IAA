package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.ConsoleUtil;
import de.nordakademie.roommgmt.dao.DAOFactory;
import de.nordakademie.roommgmt.dao.RoomDAOImpl;
import de.nordakademie.roommgmt.model.Room;


public class CreateRoomAction extends Action {

	@Override
	public String getLabel() {
		return "Einen neuen Raum anlegen.";
	}

	@Override
	public void execute() throws Exception {
		System.out.println("Geben Sie eine Raumnummer an!");
		int roomNR = ConsoleUtil.readInt();
		System.out.println("Geben Sie eine Gebäude an!");
		String gebaeude= ConsoleUtil.readString();
		System.out.println("Geben Sie die Anzahl der Plätze an!");
		int kapazitaet = ConsoleUtil.readInt();
		System.out.println("Hat der Raum eine Beamer?");
		boolean hasBeamer = ConsoleUtil.readBoolean();
		
		//create
		Room room = new Room();
		room.setBeamerPresent(hasBeamer);
		room.setBuilding(gebaeude);
		room.setRoomNumber(roomNR);
		room.setSeatCount(kapazitaet);
		
		//persist
		RoomDAOImpl roomDAO = DAOFactory.createRoomDAO();
		room = roomDAO.saveRoom(room);
		System.out.printf("Raum wurde unter id %d gespeichert", room.getId());
	}

}

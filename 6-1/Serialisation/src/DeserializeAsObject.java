import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import model.Room;

public class DeserializeAsObject {

	public static void main(String[] args) throws IOException {
		ObjectInputStream roomOIS = null;
		Room room = null;
		try {
			FileInputStream fos = new FileInputStream("room.obj");
			roomOIS = new ObjectInputStream(fos);
			room = (Room) roomOIS.readObject();
			System.out.printf("Room %s%d %d seats beamer %b",
					room.getBuilding(), room.getRoomNumber(),
					room.getSeatCount(), room.hasBeamer());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (roomOIS != null) {
				roomOIS.close();
			}
		}
	}
}

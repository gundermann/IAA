import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.Room;

public class SerializeAsObject {

	public static void main(String[] args) throws IOException {
		Room room = new Room();
		room.setId(1000L);
		room.setBeamer(true);
		room.setBuilding("C");
		room.setSeatCount(5000);
		room.setRoomNumber(110);

		ObjectOutputStream roomOOS = null;
		try {
			FileOutputStream fos = new FileOutputStream("room.obj");
			roomOOS = new ObjectOutputStream(fos);
			roomOOS.writeObject(room);
			roomOOS.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (roomOOS != null) {
				roomOOS.close();
			}
		}
	}
}

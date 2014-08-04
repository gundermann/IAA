import java.io.FileOutputStream;
import java.io.IOException;

import model.Room;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SerializeAsXML {

	public static void main(String[] args) throws IOException {
		Room room = new Room();
		room.setId(1000L);
		room.setBeamer(true);
		room.setBuilding("C");
		room.setSeatCount(5000);
		room.setRoomNumber(110);
		try {
			FileOutputStream fos = new FileOutputStream("room.xml");
			new XStream(new DomDriver()).toXML(room, fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

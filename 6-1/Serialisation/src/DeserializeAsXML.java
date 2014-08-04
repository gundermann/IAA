import java.io.FileInputStream;
import java.io.IOException;

import model.Room;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class DeserializeAsXML {

	public static void main(String[] args) throws IOException {
		Room room = null;
			try {
				FileInputStream fos = new FileInputStream("room.xml");
				room = (Room) new XStream(new DomDriver()).fromXML(fos, room);
				System.out.printf("Room %s%d %d seats beamer %b",
						room.getBuilding(), room.getRoomNumber(),
						room.getSeatCount(), room.hasBeamer());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

import java.util.ArrayList;
import java.util.List;

import de.nordakademie.roommgmt.ApplicationController;
import de.nordakademie.roommgmt.action.Action;
import de.nordakademie.roommgmt.action.CreateRoomAction;
import de.nordakademie.roommgmt.action.DeleteRoomAction;
import de.nordakademie.roommgmt.action.ExitAction;
import de.nordakademie.roommgmt.action.ListRoomsAction;
import de.nordakademie.roommgmt.action.ShowRoomAction;
import de.nordakademie.roommgmt.action.UpdateRoomAction;

/**
 * Main class of the room management application.
 */
public class RoomManagement {

	/**
	 * Runs the application.
	 * 
	 * @param args
	 *            Arguments (not supported).
	 */
	public static void main(String[] args) {
		ApplicationController controller = new ApplicationController();
		// Create list of actions
		List<Action> actions = new ArrayList<Action>();
		actions.add(new ListRoomsAction());
		actions.add(new ShowRoomAction());
		actions.add(new CreateRoomAction());
		actions.add(new UpdateRoomAction());
		actions.add(new DeleteRoomAction());
		actions.add(new ExitAction());

		controller.setActions(actions);
		// Show menu
		controller.showMenu();
	}
}

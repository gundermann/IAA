import java.util.ArrayList;
import java.util.List;

import de.nordakademie.roommgmt.ApplicationController;
import de.nordakademie.roommgmt.action.Action;

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

		controller.setActions(actions);
		// Show menu
		controller.showMenu();
	}
}

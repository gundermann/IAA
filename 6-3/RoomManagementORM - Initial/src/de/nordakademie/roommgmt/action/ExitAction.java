package de.nordakademie.roommgmt.action;

import de.nordakademie.roommgmt.HibernateUtil;

public class ExitAction extends Action {

	/** {@inheritDoc} */
	@Override
	public String getLabel() {
		return "Beenden!";
	}

	/** {@inheritDoc} */
	@Override
	public void execute() throws Exception {
		HibernateUtil.getSessionFactory().close();
		System.out.println("Raumverwaltung beendet!");
		System.exit(0);
	}

}

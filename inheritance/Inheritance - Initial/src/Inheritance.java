import model.Kreditkartenzahlung;
import model.Lastschriftzahlung;

import org.hibernate.classic.Session;

public class Inheritance {

	public static void main(String[] args) {
		Lastschriftzahlung lastschriftzahlung = new Lastschriftzahlung();
		lastschriftzahlung.setInhaber("Stefan Reichert");
		lastschriftzahlung.setKontonummer("Unicredit-1234567890");

		Kreditkartenzahlung kreditkartenzahlung = new Kreditkartenzahlung();
		kreditkartenzahlung.setInhaber("Stefan Reichert");
		kreditkartenzahlung.setTyp("Eurocard");

		Session session = HibernateUtil.getSessionfactory().getCurrentSession();
		session.beginTransaction();
		session.save(lastschriftzahlung);
		session.save(kreditkartenzahlung);
		session.getTransaction().commit();
	}

}

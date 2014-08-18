package de.nordakademie.roommgmt;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate util class.
 */
public class HibernateUtil {
	/** The session factory. */
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			sessionFactory = configuration.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Initialization failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Returns the session factory.
	 * 
	 * @return a SessionFactory object.
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

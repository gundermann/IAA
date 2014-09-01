import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable throwable) {
			System.err.println("Initialization failed: "
					+ throwable.getMessage());
			throw new ExceptionInInitializerError(throwable);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}

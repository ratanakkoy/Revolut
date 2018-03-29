package ratanak.revolutTransfers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	private static SessionUtil instance = new SessionUtil();
	// private SessionFactory sessionFactory;
	private EntityManagerFactory emf;

	public static SessionUtil getInstance() {
		return instance;
	}

	private SessionUtil() {
		// Configuration configuration = new Configuration();
		// configuration.configure("hibernate.cfg.xml");

		// sessionFactory = configuration.buildSessionFactory();

		emf = Persistence.createEntityManagerFactory("revolut");
	}

	public static EntityManager getEntityManager() {
		// Session session = getInstance().sessionFactory.openSession();
		EntityManager em = getInstance().emf.createEntityManager();
		return em;
	}
}

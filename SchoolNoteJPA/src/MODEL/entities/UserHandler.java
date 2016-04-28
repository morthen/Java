package MODEL.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * The Class UserHandler.
 */
public class UserHandler {

	/** The Constant Persistence Unit Name. */
	private static final String PUN = "SchoolNote";
	
	/** The EntityManager factory. */
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory(PUN);
	}
	
	/** The current name list. */
	private static List<String> currentNameList;

	/**
	 * Adds the users.
	 *
	 * @param u the u
	 * 
	 * @author Martin Özgun
	 */
	public static void addUsers(User u) {
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		}
		
		catch (Throwable t) {
			System.err.println("Error: " + t + " " + t.getClass() + " "
					+ t.getMessage());
			throw t;
		} finally {
			em.close();
		}

	}

	/**
	 * List all Users' name in the database.
	 *
	 * @return the list of users.name
	 * 
	 * @author Martin Özgun
	 */
	
	public static List<String> listUsers() {
		currentNameList = new ArrayList<String>();
		EntityManager em = factory.createEntityManager();
		String noteString = null;

		Query q = em.createQuery("select u from User u");

		@SuppressWarnings("unchecked")
		List<User> userList = q.getResultList();
		for (User u : userList) {
			noteString = u.getUsername();
			currentNameList.add(noteString);	
		}
		return currentNameList;

	}

	/**
	 * Validation.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the string
	 * 
	 * @author Martin Özgun
	 */
	
	public static String validation(String userName, String password) {
		
		String flag = null;
		EntityManager em = factory.createEntityManager();

		Query q = em
				.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :pass");
		q.setParameter("username", userName);
		q.setParameter("pass", password);
		try {
			User user = (User) q.getSingleResult();
			if (userName.equalsIgnoreCase(user.getUsername())
					&& password.equals(user.getPassword())) {
				flag = "success";
			}
		} catch (Exception e) {
			return null;
		}

		return flag;
	}

	/**
	 * Get the Username from the Controller, which we then can query to the database, to get the whole entity-object.
	 * With the entity-object, we can get the specified name.
	 *
	 * @param username the username
	 * @return the namefrom username
	 * 
	 * @author Martin Özgun
	 */
	
	public static String getNamefromUsername(String username) {

		EntityManager em = factory.createEntityManager();
		String currentName = null;

		User user = em.find(User.class, username);
		currentName = user.getName();
		return currentName;

	}

}
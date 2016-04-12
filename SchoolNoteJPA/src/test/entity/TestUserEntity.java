package test.entity;

import org.junit.*;

import MODEL.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static junit.framework.Assert.*;


/**
 * JUnit test class for User Entity.
 * 
 * @author Ludwig Slotte
 */
public class TestUserEntity {

	/** The EntityManager. */
	private static EntityManager em = null;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			setUpClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestUserEntity tne = new TestUserEntity();
		tne.testAllOps();
	}

	/**
	 * Sets the up class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
		if (em == null) {
			em = (EntityManager) Persistence.createEntityManagerFactory(
					"TestSchoolNote").createEntityManager();
		}
	}


	/**
	 * Test user entity.
	 */
	@Test
	public void testAllOps() {
		// Start a transaction
		em.getTransaction().begin();

		// ------------ Create a User U1 ---------
		User u1 = new User();
		u1.setName("This is the first User u1");
		u1.setPassword("password");
		u1.setUsername("Berti ");

		// At this Point the Entity does not have a
		// Persistent Identity and is not associated
		// with a persistent Context
		em.persist(u1); // Persist the Entity
		em.flush();
		// At this point the Entity has a Persistent
		// Identity and is associated witha Persistent
		// context.

		// ------------ Create a USER u2 ---------
		User u2 = new User();
		u2.setName("This is the second User u2");
		u2.setPassword("password 2");
		u2.setUsername("Bertil K");

		em.persist(u2);
		em.flush();

		System.out.println("User 1 UsernameId : " + u1.getUsername());
		System.out.println("User 2 UsernameId : " + u2.getUsername());

		// ------------ Perform Selects ---------
		Query query = em.createQuery("Select u from User u where u.username=:userid");
		query.setParameter("userid", u1.getUsername());
		User retrieved1 = (User) query.getSingleResult();
		assertSame(u1, retrieved1);

		query.setParameter("userid", u2.getUsername());
		User retrieved2 = (User) query.getSingleResult();
		assertSame(u2, retrieved2);

		assertNotSame(u1, u2);
		assertNotSame(retrieved1, retrieved2);

		// ------------ Update ---------

		u2.setName("No User u2");

		em.merge(u2);
		em.flush();

		System.out.println("User 2 Id : " + u2.getUsername());
		System.out.println("User 2 Name : " + u2.getName());
		System.out.println("User 2 Pass : " + u2.getPassword());
		// ------------ Remove Entries ---------
		em.remove(u1);
		em.remove(u2);
		// Both u1 u2 (and obviously retrieved1 and retrieved2) are removed,
		// which will happen upon commit of the Transaction

		em.getTransaction().commit();
	}
}
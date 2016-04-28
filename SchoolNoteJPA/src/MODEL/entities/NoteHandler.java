package MODEL.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 * The Class NoteHandler.
 */
public class NoteHandler {

	/** The Constant Persistence Unit Name. */
	private static final String PUN = "SchoolNote";
	
	/** The EntityManager factory. */
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory(PUN);
	}
	/** The current name list. */
	static List<Note> currentNameList;

	/**
	 * Gets the note from the unique id that we got from the Controller, 
	 * so we can find that entity-object that we are searching for.
	 *
	 * @param id the id of the note.
	 * @return the note from the id.
	 * 
	 * @author Martin Özgun
	 */
	public static String getNoteFromId(long id) {
		EntityManager em = factory.createEntityManager();
		String currentName = null;

		Note note = em.find(Note.class, id);
		currentName = note.getNote();
		return currentName;

	}

	/**
	 * 
	 * Method to get a list of all <code>note</code>-objects written by the specified <code>User</code>.
	 * Query to the database to get all <code>notes<code> from the unique key of <code>Username</code>.
	 * Set a List to <code>noteList</code> of <code>note</code>-objects from the result of the query.
	 * 
	 * @param username for the user that we want to retrieve the notes from
	 * @return List of <code>Note</code>'s with results from the query
	 * 
	 * @author Ludwig Slotte
	 */
	
	public static List<Note> getNotefromUsername(String username) {
		EntityManager em = factory.createEntityManager();

		Query q = em
				.createQuery("select n from Note n WHERE n.username LIKE :user");
		q.setParameter("user", username);

		@SuppressWarnings("unchecked")
		List<Note> noteList = q.getResultList();

		return noteList;

	}



	/**
	 * Gets the unique Note-ID from the specified note that we recieve from the Controller.
	 *
	 * @param note the note that we want the id from
	 * @return the note id of the specified note
	 * 
	 * @author Ludwig Slotte
	 */
	
	public static long getNoteId(String note) {
		long noteId = 0;
//		factory = Persistence.createEntityManagerFactory(PUN);
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("select n from Note n WHERE n.note = :note");
		q.setParameter("note", note);

		@SuppressWarnings("unchecked")
		List<Note> noteList = q.getResultList();

		for (Note n : noteList) {
			System.out.println(n.getId());
			noteId = (long) n.getId();

		}

		return noteId;

	}

	/**
	 * Adds the note-object to the EntityManager, which then saves the data to the database-table Notes.
	 * The note-object holds the name of who wrote the note, the written note, and a auto-generated unique-key.
	 *
	 * @param note the note-object that we want to save to the database
	 * 
	 * @author Ludwig Slotte
	 */
	public static void addNote(Note note) {
//		factory = Persistence.createEntityManagerFactory(PUN);
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(note);
			em.getTransaction().commit();

		} catch (Throwable t) {
			System.out.println(t + " " + t.getClass() + " " + t.getMessage());
		} finally {
			em.close();
		}
	}

	/**
	 *  Delete the note via the EntityManager, we first find the note
	 *  with the unique id that we have specified from the controller. 
	 *  The note then gets deleted by the EntityManager.
	 *  
	 *
	 * @param noteId the note id of the note that the controller wants to delete.
	 * 
	 * @author Ludwig Slotte
	 */
	
	public static void deleteNote(long noteId) {
		
		EntityManager em = factory.createEntityManager();
		Note note = em.find(Note.class, noteId);
		try {
			em.getTransaction().begin();
			em.remove(note);
			em.getTransaction().commit();

		} catch (Throwable t) {
			System.out.println(t + " " + t.getClass() + " " + t.getMessage());
		} finally {
			em.close();
		}
	}

}

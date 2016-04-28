package test.entity;
import org.junit.*;

import MODEL.entities.Note;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static junit.framework.Assert.*;


/**
 * JUnit test class for Note Entity.
 * 
 * @author Martin Özgun
 */
public class TestNoteEntity {

    /** The EntityManaer. */
    private static EntityManager em = null;


    public static void main(String[] args){
    	try {
			setUpClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	TestNoteEntity tne = new TestNoteEntity();
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
            em = (EntityManager) Persistence.createEntityManagerFactory("TestSchoolNote").createEntityManager();
        }
    }

    /**
     * Test note entity.
     */
    @Test
    public void testAllOps(){
        // Start a transaction
        em.getTransaction().begin();

        // ------------  Create a Company C1 ---------
        Note n1 = new Note();
        n1.setNote("This is the first note n1");
        n1.setUsername("Berti ");
  
  
        // At this Point the Entity does not have a
        // Persistent Identity and is not associated
        // with a persistent Context
        em.persist(n1); // Persist the Entity
        em.flush();
        // At this point the Entity has a Persistent
        // Identity and is associated witha Persistent
        // context.

        // ------------  Create a Company C2 ---------
        Note n2 = new Note();
        n2.setNote("This is the second note n2");
        n2.setUsername("Kalle K ");
      
        em.persist(n2);
        em.flush();

        System.out.println("Note 1 Id : " + n1.getId());
        System.out.println("Note 2 Id : " + n2.getId());

        // ------------  Perform Selects ---------
        Query query = em.createQuery("Select n from Note n where n.id=:noteid");
        query.setParameter("noteid", n1.getId());
        Note retrieved1 = (Note) query.getSingleResult();
        assertSame(n1, retrieved1);

        query.setParameter("noteid", n2.getId());
        Note retrieved2 = (Note) query.getSingleResult();
        assertSame(n2,retrieved2);

        assertNotSame(n1,n2);
        assertNotSame(retrieved1,retrieved2);

        // ------------  Update  ---------

        n2.setNote("No Note n2");
  
        em.merge(n2);
        em.flush();

        System.out.println("Note 2 Id : " + n2.getId());
        System.out.println("Note 2 Note : " + n2.getNote());
      

        // ------------  Remove Entries  ---------
        em.remove(n1);
        em.remove(n2);
        // Both n1 n2 (and obviously retrieved1 and retrieved2) are removed,
        // which will happen upon commit of the Transaction

        
        //TODO ROLLBACK SHUT DOWN WITHOUT COMMIT
        em.getTransaction().commit();
    }
}
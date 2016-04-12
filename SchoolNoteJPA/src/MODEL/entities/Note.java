package MODEL.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NOTES database table.
 * 
 */
@Entity
@Table(name = "NOTES")
@NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
public class Note implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Id
	@GeneratedValue
	private long id;

	/** The note. */
	@Lob
	private String note;

	/** The username. */
	private String username;

	/**
	 * Instantiates a new note.
	 */
	public Note() {
	}

	/**
	 * Instantiates a new note.
	 *
	 * @param note the note
	 * @param userName the user name
	 */
	public Note(String note, String userName) {
		this.note = note;
		this.username = userName;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + ", username=" + username
				+ "]";
	}

	/**
	 * Gets the note.
	 *
	 * @return the note
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * Sets the note.
	 *
	 * @param note the new note
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

}
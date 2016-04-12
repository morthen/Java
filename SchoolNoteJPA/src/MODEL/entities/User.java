package MODEL.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERS2 database table.
 * 
 */
@Entity
@Table(name = "USERS2")
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The username. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String username;

	/** The name. */
	private String name;

	/** The password. */
	private String password;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Instantiates a new user.
	 *
	 * @param username the username
	 * @param name the name
	 * @param password the password
	 */
	public User(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", password="
				+ password + "]";
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

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
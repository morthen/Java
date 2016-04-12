package se.martin.jpa.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tblIssues")
public class Issue extends AbstractEntity {

	private String title;
	private String description;

	@OneToOne()
	@Transient
	private WorkItem workItem;

	public Issue(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Issue addWorkItem(WorkItem item) {
		this.workItem = item;
		return this;
	}

	protected Issue() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

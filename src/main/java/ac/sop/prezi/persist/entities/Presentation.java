package ac.sop.prezi.persist.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "presentations")
public class Presentation implements Serializable {

	private static final long serialVersionUID = 3350089433408617098L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "presentation_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name="user_ID")
	private User user;

	@Column(name = "name")
	private String name;

	@Column(name = "creation_date")
	private Date creationDate;


	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}

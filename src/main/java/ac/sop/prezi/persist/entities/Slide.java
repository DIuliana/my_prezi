package ac.sop.prezi.persist.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="slides")
public class Slide implements Serializable{

	private static final long serialVersionUID = 9215724287392199409L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "slide_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="presentation_ID")
	private Presentation presentation;
	
	@Column(name="name")
	private String name;
	
	@Column(name="position")
	private Integer position;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Presentation getPresentation() {
		return presentation;
	}

	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
}

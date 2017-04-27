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
@Table(name = "contents")
public class Content implements Serializable {

	private static final long serialVersionUID = -8243492026459367809L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "content_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "slide_ID")
	private Slide slide;

	@Column(name = "position")
	private Integer position;

	@Column(name = "url")
	private String url;

	@Column(name = "text")
	private String text;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Slide getSlide() {
		return slide;
	}

	public void setSlide(Slide slide) {
		this.slide = slide;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}

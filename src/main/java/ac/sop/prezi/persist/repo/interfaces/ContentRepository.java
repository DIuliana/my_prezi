package ac.sop.prezi.persist.repo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.sop.prezi.persist.entities.Content;
import ac.sop.prezi.persist.entities.Slide;

public interface ContentRepository extends JpaRepository<Content, Long> {
	
	List<Content> findBySlide(Slide slide);

	Content findById(Long contentId);

}

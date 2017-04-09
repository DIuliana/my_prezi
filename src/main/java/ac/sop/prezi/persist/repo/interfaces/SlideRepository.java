package ac.sop.prezi.persist.repo.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.persist.entities.Slide;

public interface SlideRepository extends JpaRepository<Slide, Long> {

	List<Slide> findByPresentation(Presentation presentation);

}

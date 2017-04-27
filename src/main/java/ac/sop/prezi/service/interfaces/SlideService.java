package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Slide;


public interface SlideService {

	List<Slide> findAllByPresentationId(Long presentationId);

	void save(Long presentationId, Slide slide);
	
	Slide findBySlideId(Long slideId);
	
}

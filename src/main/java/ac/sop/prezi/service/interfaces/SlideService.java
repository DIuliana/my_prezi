package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Slide;


public interface SlideService {

	List<Slide> findByPresentationId(Long userId, Long presentationId);

	void save(Long userId, Long presentationId, Slide slide);
	
	Slide findBySlideId(Long userId, Long presentationId, Long slideId);

}

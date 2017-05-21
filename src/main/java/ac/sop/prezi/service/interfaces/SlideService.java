package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Slide;
import ac.sop.prezi.service.PresentationNotFoundException;
import ac.sop.prezi.service.SlideNotFoundException;


public interface SlideService {

	List<Slide> findAllByPresentationId(Long presentationId) throws PresentationNotFoundException;

	void save(Long presentationId, Slide slide) throws PresentationNotFoundException;
	
	Slide findBySlideId(Long slideId) throws SlideNotFoundException;
	
}

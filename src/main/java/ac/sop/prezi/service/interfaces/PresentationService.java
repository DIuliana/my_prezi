package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Presentation;

public interface PresentationService {

	List<Presentation> findAllByUserId(Long userId);

	void save(Long userId, Presentation presentation);

	Presentation findByPresentationId(Long presentationId);

}
package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.service.PresentationNotFoundException;
import ac.sop.prezi.service.UserNotFoundException;

public interface PresentationService {

	List<Presentation> findAllByUserId(Long userId) throws UserNotFoundException;

	void save(Long userId, Presentation presentation) throws UserNotFoundException;

	Presentation findByPresentationId(Long presentationId)throws PresentationNotFoundException;

}
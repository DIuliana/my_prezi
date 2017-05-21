package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.persist.repo.interfaces.PresentationRepository;
import ac.sop.prezi.service.interfaces.PresentationService;
import ac.sop.prezi.service.interfaces.UserService;

@Service
public class PresentationServiceImpl implements PresentationService {

	@Autowired
	PresentationRepository presentationRepository;

	@Autowired
	UserService userService;

	@Override
	public List<Presentation> findAllByUserId(Long userId) throws UserNotFoundException {

		User user = userService.findById(userId);

		return presentationRepository.findByUser(user);
	}

	@Override
	public void save(Long userId, Presentation presentation) throws UserNotFoundException {

		User user = userService.findById(userId);
		// needs checks
		presentation.setUser(user);

		presentationRepository.save(presentation);

	}

	@Override
	public Presentation findByPresentationId(Long presentationId) throws PresentationNotFoundException {

		Presentation presentation = presentationRepository.findById(presentationId);
		if (presentation == null) {
			throw new PresentationNotFoundException();
		} else {
			return presentation;
		}

	}

}

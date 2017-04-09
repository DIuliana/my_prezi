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
	public List<Presentation> findAllByUserId(Long userId) {

		User user = userService.findById(userId);

		return presentationRepository.findByUser(user);
	}

	@Override
	public Presentation findByUserIdAndPresentationId(Long userId, Long presentationId) {

		List<Presentation> presentations = findAllByUserId(userId);

		for (Presentation pres : presentations) {

			if (pres.getId().equals(presentationId)) {
				return pres;
			}

		}
		return null;

	}

	@Override
	public void save(Long userId, Presentation presentation) {

		User user = userService.findById(userId);
		//needs checks
		presentation.setUser(user);

		presentationRepository.save(presentation);

	}

}

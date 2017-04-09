package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.persist.entities.Slide;
import ac.sop.prezi.persist.repo.interfaces.SlideRepository;
import ac.sop.prezi.service.interfaces.PresentationService;
import ac.sop.prezi.service.interfaces.SlideService;

@Service
public class SlideServiceImpl implements SlideService {

	@Autowired
	SlideRepository slideRepository;

	@Autowired
	PresentationService presentationService;

	@Override
	public List<Slide> findByPresentationId(Long userId, Long presentationId) {

		Presentation presentation = presentationService.findByUserIdAndPresentationId(userId, presentationId);

		return slideRepository.findByPresentation(presentation);

	}

	@Override
	public void save(Long userId, Long presentationId, Slide slide) {

		Presentation presentation = presentationService.findByUserIdAndPresentationId(userId, presentationId);

		// needs checks
		slide.setPresentation(presentation);

		slideRepository.save(slide);

	}

	@Override
	public Slide findBySlideId(Long userId, Long presentationId, Long slideId) {

		List<Slide> slides = findByPresentationId(userId, presentationId);

		for (Slide slide : slides) {

			if (slide.getId().equals(slideId)) {
				return slide;
			}

		}
		return null;
	}

}

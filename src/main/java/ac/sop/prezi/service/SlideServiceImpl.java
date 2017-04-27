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
	public List<Slide> findAllByPresentationId(Long presentationId) {

		Presentation presentation = presentationService.findByPresentationId(presentationId);

		return slideRepository.findByPresentation(presentation);

	}

	@Override
	public void save(Long presentationId, Slide slide) {

		Presentation presentation = presentationService.findByPresentationId(presentationId);

		// needs checks
		slide.setPresentation(presentation);

		slideRepository.save(slide);

	}

	@Override
	public Slide findBySlideId(Long slideId) {

		return slideRepository.findById(slideId);

	}
}

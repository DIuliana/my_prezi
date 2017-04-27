package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.Content;
import ac.sop.prezi.persist.entities.Slide;
import ac.sop.prezi.persist.repo.interfaces.ContentRepository;
import ac.sop.prezi.persist.repo.interfaces.SlideRepository;
import ac.sop.prezi.service.interfaces.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	ContentRepository contentRepository;

	@Autowired
	SlideRepository slideRepostory;

	@Override
	public List<Content> findAllBySlideId(Long slideId) {

		Slide slide = slideRepostory.findById(slideId);

		return contentRepository.findBySlide(slide);

	}

	@Override
	public void save(Long slideId, Content content) {

		Slide slide = slideRepostory.findById(slideId);
		// needs checks
		content.setSlide(slide);

		contentRepository.save(content);

	}

	@Override
	public Content findByContentId(Long contentId) {

		return contentRepository.findById(contentId);
	}

}

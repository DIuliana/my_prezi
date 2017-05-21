package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.Content;
import ac.sop.prezi.persist.entities.Slide;
import ac.sop.prezi.persist.repo.interfaces.ContentRepository;
import ac.sop.prezi.service.interfaces.ContentService;
import ac.sop.prezi.service.interfaces.SlideService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	ContentRepository contentRepository;

	@Autowired
	SlideService slideService;

	@Override
	public List<Content> findAllBySlideId(Long slideId) throws SlideNotFoundException {

		Slide slide = slideService.findBySlideId(slideId);

		return contentRepository.findBySlide(slide);

	}

	@Override
	public void save(Long slideId, Content content) throws SlideNotFoundException {

		Slide slide = slideService.findBySlideId(slideId);
		// needs checks
		content.setSlide(slide);

		contentRepository.save(content);

	}

	@Override
	public Content findByContentId(Long contentId) throws ContentNotFoundException {

		Content content = contentRepository.findById(contentId);
		if (content == null) {
			throw new ContentNotFoundException();
		} else {
			return content;
		}

	}

}

package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Content;
import ac.sop.prezi.service.ContentNotFoundException;
import ac.sop.prezi.service.SlideNotFoundException;

public interface ContentService {

	List<Content> findAllBySlideId(Long slideId) throws SlideNotFoundException;

	void save(Long slideId, Content content) throws SlideNotFoundException;

	Content findByContentId(Long contentId) throws ContentNotFoundException;

}

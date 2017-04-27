package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Content;


public interface ContentService {

	List<Content> findAllBySlideId(Long slideId);

	void save(Long slideId, Content content);

	Content findByContentId(Long contentId);

}

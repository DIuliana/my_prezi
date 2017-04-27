package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Content;
import ac.sop.prezi.service.interfaces.ContentService;

@RestController
@RequestMapping(value = "/users/{userId}/presentations/{presentationId}/slides/{slideId}/contents")
public class ContentController {

	@Autowired
	ContentService contentService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Content> findAllBySlieId(@PathVariable Long slideId) {

		return contentService.findAllBySlideId(slideId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public void save(@PathVariable Long slideId, @RequestBody Content content) {

		contentService.save(slideId, content);

	}

	@RequestMapping(value = "/{contentId}", method = RequestMethod.GET)
	public Content findByContentId(@PathVariable Long contentId) {

		return contentService.findByContentId(contentId);

	}
}

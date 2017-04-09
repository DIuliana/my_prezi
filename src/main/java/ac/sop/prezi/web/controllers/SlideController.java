package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Slide;
import ac.sop.prezi.service.interfaces.SlideService;

@RestController
@RequestMapping(value = "/users/{userId}/presentations/{presentationId}/slides")
public class SlideController {

	@Autowired
	SlideService slideService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Slide> getAll(@PathVariable Long userId, @PathVariable Long presentationId) {

		return slideService.findByPresentationId(userId, presentationId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public void save(@PathVariable Long userId, @PathVariable Long presentationId, @RequestBody Slide slide) {

		slideService.save(userId, presentationId, slide);

	}

	@RequestMapping(value = "/{slideId}", method = RequestMethod.GET)
	public Slide getByUserIsPresentationIdAndSLideId(@PathVariable Long userId, @PathVariable Long presentationId,
			@PathVariable Long slideId) {

		return slideService.findBySlideId(userId, presentationId, slideId);

	}
}
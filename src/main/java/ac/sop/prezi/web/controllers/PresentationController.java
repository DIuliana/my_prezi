package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.service.interfaces.PresentationService;

@RestController
@RequestMapping(value = "/users/{userId}/presentations")
public class PresentationController {

	@Autowired
	PresentationService presentationService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Presentation> findAllByUserId(@PathVariable Long userId) {

		return presentationService.findAllByUserId(userId);

	}

	@RequestMapping(method = RequestMethod.POST)
	public void save(@PathVariable Long userId, @RequestBody Presentation presentation) {

		presentationService.save(userId, presentation);

	}

	@RequestMapping(value = "/{presentationId}", method = RequestMethod.GET)
	public Presentation findByPresentationId(@PathVariable Long presentationId) {

		return presentationService.findByPresentationId(presentationId);

	}

}

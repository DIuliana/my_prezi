package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Slide;
import ac.sop.prezi.service.PresentationNotFoundException;
import ac.sop.prezi.service.SlideNotFoundException;
import ac.sop.prezi.service.interfaces.SlideService;

@RestController
@RequestMapping(value = "/users/{userId}/presentations/{presentationId}/slides")
public class SlideController {

	@Autowired
	SlideService slideService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAllByPresentationId(@PathVariable Long presentationId) {

		try {
			List<Slide> slides = slideService.findAllByPresentationId(presentationId);
			return new ResponseEntity<>(slides, HttpStatus.OK);
		} catch (PresentationNotFoundException exception) {
			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@PathVariable Long presentationId, @RequestBody Slide slide) {
		try {
			slideService.save(presentationId, slide);
			return new ResponseEntity<>("slide added", HttpStatus.OK);
		} catch (PresentationNotFoundException exception) {
			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{slideId}", method = RequestMethod.GET)
	public ResponseEntity<?> findBySlideId(@PathVariable Long slideId) {

		try{
			Slide slide=slideService.findBySlideId(slideId);
			return new ResponseEntity<>(slide, HttpStatus.OK);
		}
		catch (SlideNotFoundException exception) {
			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
		

	}
}
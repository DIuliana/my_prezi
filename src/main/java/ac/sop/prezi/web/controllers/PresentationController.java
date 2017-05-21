package ac.sop.prezi.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Presentation;
import ac.sop.prezi.service.PresentationNotFoundException;
import ac.sop.prezi.service.UserNotFoundException;
import ac.sop.prezi.service.interfaces.PresentationService;

@RestController
@RequestMapping(value = "/users/{userId}/presentations")
public class PresentationController {

	@Autowired
	PresentationService presentationService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAllByUserId(@PathVariable Long userId) {

		try {
			List<Presentation> pres = new ArrayList<>();
			pres = presentationService.findAllByUserId(userId);
			return new ResponseEntity<>(pres, HttpStatus.OK);
		} catch (UserNotFoundException exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@PathVariable Long userId, @RequestBody Presentation presentation) {
		try {
			presentationService.save(userId, presentation);
			return new ResponseEntity<>("presentation added", HttpStatus.OK);
		} catch (UserNotFoundException exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/{presentationId}", method = RequestMethod.GET)
	public ResponseEntity<?> findByPresentationId(@PathVariable Long presentationId) {

		try {

			Presentation presentation = presentationService.findByPresentationId(presentationId);
			return new ResponseEntity<>(presentation, HttpStatus.OK);
		}

		catch (PresentationNotFoundException exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}
	}

}

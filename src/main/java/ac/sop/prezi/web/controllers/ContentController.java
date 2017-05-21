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

import ac.sop.prezi.persist.entities.Content;
import ac.sop.prezi.service.ContentNotFoundException;
import ac.sop.prezi.service.SlideNotFoundException;
import ac.sop.prezi.service.interfaces.ContentService;

@RestController
@RequestMapping(value = "/users/{userId}/presentations/{presentationId}/slides/{slideId}/contents")
public class ContentController {

	@Autowired
	ContentService contentService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAllBySlieId(@PathVariable Long slideId) {

		try {
			List<Content> contents = contentService.findAllBySlideId(slideId);
			return new ResponseEntity<>(contents, HttpStatus.OK);
		} catch (SlideNotFoundException exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@PathVariable Long slideId, @RequestBody Content content) {

		try {
			contentService.save(slideId, content);
			return new ResponseEntity<>("content added", HttpStatus.OK);
		} catch (SlideNotFoundException exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/{contentId}", method = RequestMethod.GET)
	public ResponseEntity<?> findByContentId(@PathVariable Long contentId) {

		try {
			Content content = contentService.findByContentId(contentId);
			return new ResponseEntity<>(content, HttpStatus.OK);
		} catch (ContentNotFoundException exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}
}

package ac.sop.prezi.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundExcecption;
import ac.sop.prezi.service.interfaces.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET)
	public ResponseEntity<?> auth(@PathVariable String username, @PathVariable String password) {

		try {
			User user = authService.auth(username, password);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (UserNotFoundExcecption exception) {

			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}
}
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

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundException;
import ac.sop.prezi.service.interfaces.UserService;

@RestController
@RequestMapping("/users")
public class UserContoller {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> getAll() {

		return userService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Long id) {
		try {
			User user = userService.findById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (UserNotFoundException exception) {
			String errorMessage;
			errorMessage = exception + " <== error";
			return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody User user) {

		userService.save(user);
	}

}

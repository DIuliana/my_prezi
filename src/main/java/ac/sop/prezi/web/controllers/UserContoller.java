package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.User;
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
	public User findById(@PathVariable Long id) {
		
		return userService.findById(id);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody User user) {
		
		userService.save(user);
	}

}

package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.interfaces.RoleService;
import ac.sop.prezi.service.interfaces.UserService;

@RestController
@RequestMapping(value = "/users")

public class UserContoller {

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

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

	@RequestMapping(value = "/usernames/{username}", method = RequestMethod.GET)
	public User findByUserName(@PathVariable String username) {

		return userService.findByUserName(username);
	}

	@RequestMapping(value = "/roles/{name}", method = RequestMethod.GET)
	public List<User> findUsersByRole(@PathVariable String name) {

		Role role = roleService.findByName(name);

		return userService.findUsersByRole(role);

	}

}

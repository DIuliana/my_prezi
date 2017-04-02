package ac.sop.prezi.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.service.interfaces.RoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Role> getAll() {

		return roleService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role findById(@PathVariable long id) {

		return roleService.findById(id);
	}

}

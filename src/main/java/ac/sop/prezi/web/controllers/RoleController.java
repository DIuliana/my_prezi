package ac.sop.prezi.web.controllers;

import java.util.List;

import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.InvalidInputException;
import ac.sop.prezi.web.controllers.utils.SuccessMessage;
import ac.sop.prezi.web.controllers.utils.SuccessMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.service.interfaces.RoleService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

	@Autowired
	RoleService roleService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Role> getAll() {

		return roleService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Role save(@RequestBody  Role role) throws InvalidInputException {

		return roleService.save(role);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role findById(@PathVariable Long id) throws EntityNotFoundException{

		return roleService.findById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public SuccessMessage delete(@PathVariable Long id) throws EntityNotFoundException{

		 roleService.delete(id);
		 return new SuccessMessage(SuccessMessages.DELETED_ROLE.message + id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Role update(@PathVariable Long id, @RequestBody Role role) throws EntityNotFoundException, InvalidInputException{

		return roleService.update(id, role);
	}
}

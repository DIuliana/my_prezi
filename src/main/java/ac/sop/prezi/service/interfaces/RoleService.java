package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.InvalidInputException;

public interface RoleService {

	Role findById(Long id) throws EntityNotFoundException;
	List<Role>findAll();
	Role save(Role role) throws InvalidInputException;
	void delete(Long id) throws  EntityNotFoundException, InvalidInputException;
	Role findByName(String name);
	Role update(Long id, Role role) throws EntityNotFoundException, InvalidInputException;
}

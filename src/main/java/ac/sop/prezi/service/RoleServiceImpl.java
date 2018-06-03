package ac.sop.prezi.service;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.persist.repo.interfaces.RoleRepository;
import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.ExceptionMessages;
import ac.sop.prezi.service.exceptions.InvalidInputException;
import ac.sop.prezi.service.interfaces.RoleService;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role findById(Long id) throws EntityNotFoundException {

		Role role = roleRepository.findOne(id);
		if (role == null) {
			throw new EntityNotFoundException(ExceptionMessages.ROLE_NOT_FOUND_ID.message + id);
		}
		return role;
	}

	@Override
	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	@Override
	public Role findByName(String name) {
		
		return roleRepository.findByName(name);
	}

	@Override
	public Role save(Role role) throws InvalidInputException {

		if (role.getName() == null) {
			throw new InvalidInputException(ExceptionMessages.ROLE_NAME_MANDATORY.message);
		}
		return roleRepository.save(role);
	}

	@Override
	public void delete(Long id) throws EntityNotFoundException, InvalidInputException {

		Role role = roleRepository.findOne(id);
		if (role == null) {
			throw new EntityNotFoundException(ExceptionMessages.ROLE_NOT_FOUND_ID.message + id);
		}try {
			roleRepository.delete(id);
		}catch (DataIntegrityViolationException ex){
			throw new InvalidInputException(ExceptionMessages.ROLE_FOREIGN_KEY.message);
		}
	}

	@Override
	public Role update(Long id, Role role) throws EntityNotFoundException, InvalidInputException {

		Role roleToBeUpdated = roleRepository.findOne(id);
		if (roleToBeUpdated == null) {
			throw new EntityNotFoundException(ExceptionMessages.ROLE_NOT_FOUND_ID.message + id);
		}
		if (role.getName() == null) {
			throw new InvalidInputException(ExceptionMessages.ROLE_NAME_MANDATORY.message);
		}
        mapRoleValues(role, roleToBeUpdated);
		roleRepository.save(roleToBeUpdated);
		return roleToBeUpdated;
	}

    private void mapRoleValues(Role role, Role roleToBeUpdated) {
        roleToBeUpdated.setName(role.getName());
    }
}

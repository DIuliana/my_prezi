package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundException;
import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.InvalidInputException;
import ac.sop.prezi.web.controllers.utils.SuccessMessage;

public interface UserService {


	List<User> findAll();

	User findById(Long id) throws EntityNotFoundException;

	void custom();

	User save(User user) throws InvalidInputException, EntityNotFoundException;

	SuccessMessage delete(Long id) throws EntityNotFoundException;

	User update(Long id, User user) throws EntityNotFoundException, InvalidInputException;

	User findByUserNameAndPassword(String userName, String pass) throws UserNotFoundException;

}

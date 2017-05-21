package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundException;

public interface UserService {


	List<User> findAll();

	User findById(Long id) throws UserNotFoundException;

	void custom();

	void save(User user);
	
	User findByUserNameAndPassword(String userName, String pass) throws UserNotFoundException;

}

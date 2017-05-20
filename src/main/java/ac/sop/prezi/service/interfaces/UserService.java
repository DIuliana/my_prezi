package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundExcecption;

public interface UserService {


	List<User> findAll();

	User findById(Long id);

	void custom();

	void save(User user);
	
	User findByUserNameAndPassword(String userName, String pass) throws UserNotFoundExcecption;

}

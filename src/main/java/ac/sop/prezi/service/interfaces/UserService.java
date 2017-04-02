package ac.sop.prezi.service.interfaces;

import java.util.List;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.persist.entities.User;

public interface UserService {

	void save(User user);

	List<User> findAll();
	
	User findById(long id);

	User findByUserName(String username);

	List<User>findUsersByRole(Role role);
	
	void custom();
}

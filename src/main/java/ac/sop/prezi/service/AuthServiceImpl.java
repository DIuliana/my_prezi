package ac.sop.prezi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.interfaces.AuthService;
import ac.sop.prezi.service.interfaces.UserService;


@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserService userService;

	public User auth(String userName, String pass) throws UserNotFoundExcecption {

		return userService.findByUserNameAndPassword(userName, pass);
	}

}

package ac.sop.prezi.service.interfaces;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundExcecption;

public interface AuthService {

	User auth(String userName, String pass) throws UserNotFoundExcecption;

}

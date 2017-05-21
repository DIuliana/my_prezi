package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.persist.repo.interfaces.UserRepository;
import ac.sop.prezi.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void save(User user) {

		userRepository.save(user);

	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public User findById(Long id) throws UserNotFoundException {

		User user = userRepository.findById(id);
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return user;
		}

	}

	@Override
	public void custom() {

		userRepository.customMehod();

	}

	@Override
	public User findByUserNameAndPassword(String userName, String pass) throws UserNotFoundException {

		User user = userRepository.findByUserNameAndPassword(userName, pass);
		if (user == null) {
			throw new UserNotFoundException();
		} else {
			return user;
		}
	}

}

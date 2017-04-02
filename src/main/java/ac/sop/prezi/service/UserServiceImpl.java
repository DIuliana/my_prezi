package ac.sop.prezi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.Role;
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
	public User findById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByUserName(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public List<User> findUsersByRole(Role role) {
		return userRepository.findByRole(role);

	}

	@Override
	public void custom() {
		userRepository.customMehod();

	}

}

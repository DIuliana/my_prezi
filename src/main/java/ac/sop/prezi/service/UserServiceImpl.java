package ac.sop.prezi.service;

import java.util.List;

import ac.sop.prezi.persist.entities.Role;
import ac.sop.prezi.persist.repo.interfaces.RoleRepository;
import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.ExceptionMessages;
import ac.sop.prezi.service.exceptions.InvalidInputException;
import ac.sop.prezi.web.controllers.utils.SuccessMessage;
import ac.sop.prezi.web.controllers.utils.SuccessMessages;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.persist.repo.interfaces.UserRepository;
import ac.sop.prezi.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User save(User user) throws InvalidInputException, EntityNotFoundException {

        handleInvalidInput(user);
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new InvalidInputException(ExceptionMessages.USER_USER_NAME_UNIQ.message);
        }
        return userRepository.save(user);
    }

    private void handleInvalidInput(User user) throws InvalidInputException, EntityNotFoundException {
        Long roleIdForUserUpdate = user.getRole().getId();
        Role role = roleRepository.findOne(roleIdForUserUpdate);
        if (role == null) {
            throw new EntityNotFoundException(ExceptionMessages.ROLE_NOT_FOUND_ID.message + roleIdForUserUpdate);
        }else if(!role.getName().equals(user.getRole().getName())){
            throw new InvalidInputException(ExceptionMessages.ROLE_NAME_NOT_FOUND_FOR_ID.message + roleIdForUserUpdate);
        }
        if (user.getFirstName() == null) {
            throw new InvalidInputException(ExceptionMessages.USER_FIRST_NAME_MANDATORY.message);
        } else if (user.getLastName() == null) {
            throw new InvalidInputException(ExceptionMessages.USER_LAST_NAME_MANDATORY.message);
        } else if (user.getUserName() == null) {
            throw new InvalidInputException(ExceptionMessages.USER_USER_NAME_MANDATORY.message);
        } else if (user.getEmail() == null) {
            throw new InvalidInputException(ExceptionMessages.USER_EMAIL_MANDATORY.message);
        } else if (user.getPassword() == null) {
            throw new InvalidInputException(ExceptionMessages.USER_PASSWORD_MANDATORY.message);
        }
    }

    @Override
    public SuccessMessage delete(Long id) throws EntityNotFoundException {

        if (userRepository.findOne(id) == null) {
            throw new EntityNotFoundException(ExceptionMessages.USER_NOT_FOUND_ID.message + id);
        }
        userRepository.delete(id);
        return new SuccessMessage(SuccessMessages.DELETED_USER.message + id);
    }

    public User update(Long id, User user) throws EntityNotFoundException, InvalidInputException {
        User userToBeUpdated = userRepository.findOne(id);
        if (userToBeUpdated == null) {
            throw new EntityNotFoundException(ExceptionMessages.USER_NOT_FOUND_ID.message + id);
        }
//        handleInvalidInput(user);
//        mapUserValues(userToBeUpdated, user);
//        userRepository.save(userToBeUpdated);
//        return userToBeUpdated;
        return save(user);

    }

    private void mapUserValues(User userToBeUpdated, User user) throws EntityNotFoundException {
        userToBeUpdated.setRole(user.getRole());
        userToBeUpdated.setEmail(user.getEmail());
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setUserName(user.getUserName());
        userToBeUpdated.setPassword(user.getPassword());

    }

    @Override
    public User findById(Long id) throws EntityNotFoundException {

        User user = userRepository.findOne(id);
        if (user == null) {
            throw new EntityNotFoundException(ExceptionMessages.USER_NOT_FOUND_ID.message + id);
        }
        return user;
    }

    @Override
    public void custom() {

        userRepository.customMehod();

    }

    @Override
    public User findByUserNameAndPassword(String userName, String pass) {

        User user = userRepository.findByUserNameAndPassword(userName, pass);
        if (user == null) {
        } else {
        }

        return user;
    }

}

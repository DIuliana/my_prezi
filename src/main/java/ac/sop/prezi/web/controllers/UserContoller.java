package ac.sop.prezi.web.controllers;

import java.util.List;

import ac.sop.prezi.service.exceptions.EntityNotFoundException;
import ac.sop.prezi.service.exceptions.InvalidInputException;
import ac.sop.prezi.web.controllers.utils.SuccessMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundException;
import ac.sop.prezi.service.interfaces.UserService;

@RestController
@RequestMapping("/users")
public class UserContoller {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAll() {

        return userService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(@RequestBody User user) throws InvalidInputException, EntityNotFoundException {

        return userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) throws EntityNotFoundException{

        return  userService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public SuccessMessage delete(@PathVariable Long id) throws EntityNotFoundException{

        return  userService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user) throws EntityNotFoundException, InvalidInputException{

        return  userService.update(id, user);
    }
}

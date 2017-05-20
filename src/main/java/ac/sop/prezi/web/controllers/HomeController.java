package ac.sop.prezi.web.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ac.sop.prezi.persist.entities.User;
import ac.sop.prezi.service.UserNotFoundExcecption;
import ac.sop.prezi.service.interfaces.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginForm(Model model) {

		User user = new User();

		model.addAttribute(user);
		return "index";
	}

	@RequestMapping(value = "/processForm", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute(value = "user") User user, Map<String, Object> model) {

		try {
			user=userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			// model.add presentations
			model.put("user", user);
			return new ModelAndView("presentations", model);
		} catch (UserNotFoundExcecption e) {
			model.put("user", user);
			model.put("message", "Username or password not correct!");
			return new ModelAndView("index", model);
		}

	}
}

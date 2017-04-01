package ac.sop.prezi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
		
		return "Alex este o capra mica!";
	}

}

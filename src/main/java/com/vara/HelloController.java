package com.vara;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView sayHello() {
		ModelAndView mv = new ModelAndView("/WEB-INF/views/view.jsp");
		return mv;
	}

}

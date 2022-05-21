package thales.web.model.and.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorVistas {
	@RequestMapping("/adminEmployee")
	public ModelAndView adminEmployee() {
		return new ModelAndView("adminEmployee");
	}

	@RequestMapping("/consultEmployees")
	public ModelAndView consultEmployees() {
		return new ModelAndView("consultEmployees");
	}

}

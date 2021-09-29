package com.example.springconsoleappdi.view;

import com.example.springconsoleappdi.model.Department;
import com.example.springconsoleappdi.model.User;
import org.springframework.ui.Model;

public class DepsView implements IView {

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", Department.headers);
		return IView.render(model);
	}

}

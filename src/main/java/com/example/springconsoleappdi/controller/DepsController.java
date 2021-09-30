package com.example.springconsoleappdi.controller;

import com.example.springconsoleappdi.services.DepService;
import com.example.springconsoleappdi.services.UserService;
import com.example.springconsoleappdi.view.DepsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@ShellComponent
public class DepsController {
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private DepService depService;

	@ShellMethod(key = {"Deps", "ds"}, value = "Show deps...")
	public String commandDeps(
//			@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String text,
//			@ShellOption()
//					String text2
	) {
		Model model = new ExtendedModelMap();
		Helper.getPage(model, session, depService, 0, "id", "");

		return DepsView.render(model);
	}

}

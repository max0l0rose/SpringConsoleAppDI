package com.example.springconsoleappdi.view;

import com.example.springconsoleappdi.model.User;
import org.springframework.shell.table.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class UsersView implements IView {

	//@Override
	static public String render(Model model) {
		model.addAttribute("headers", User.headers);
		return IView.render(model);
	}

}

package com.example.springconsoleappdi.controller;

import com.example.springconsoleappdi.controller.Helper;
import com.example.springconsoleappdi.model.Department;
import com.example.springconsoleappdi.model.Role;
import com.example.springconsoleappdi.model.StringsArray;
import com.example.springconsoleappdi.model.User;
import com.example.springconsoleappdi.services.UserService;
import com.example.springconsoleappdi.view.UsersView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.*;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Stream;

@ShellComponent
public class AppController
		//extends SecuredCommand
{
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private UserService userService;

//	private final static String[][] headers = new String[][] {
//			{"Id", "UserName", "Department", "Role", "Created", "Modified" },
//	};


	@ShellMethod(key = {"users", "us"}, value = "Show users...")
	public String commandUsers(
//			@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String text,
//			@ShellOption()
//					String text2
	) {
//		List<User> ulist = new ArrayList<User>() {{
//				add(new User("User1", new Department("Dep1"), Role.USER));
//				add(new User("User2", new Department("Dep1"), Role.USER));
//				add(new User("UserAdmin", new Department("Dep2"), Role.ADMIN));
//		}};
//
//		Object[][] uarr = ulist.stream()
//				.map(u -> u.toStringsArray() )
//				.toArray(size -> new Object[size][]);
//
//		//StringsArray sa = u;
//		//sampleData[1] = u.toStringsArray();

		Model model = new ExtendedModelMap();
		Helper.getPage(model, session, userService, 0, "id", "");

		return UsersView.render(model);
	}

}

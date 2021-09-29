package com.example.springconsoleappdi;

import com.example.springconsoleappdi.controller.Helper;
import com.example.springconsoleappdi.model.Department;
import com.example.springconsoleappdi.model.Role;
import com.example.springconsoleappdi.model.StringsArray;
import com.example.springconsoleappdi.model.User;
import com.example.springconsoleappdi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.*;
import org.springframework.ui.Model;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ShellComponent
public class AppCommand1
		//extends SecuredCommand
{

	Map<String,Object> session = new HashMap<>();

	@Autowired
	UserService userService;


	@ShellMethod(key = {"commandc", "cc"}, value = "commandA descript...")
	public String commandA(
//			@Size(min = 5, max = 40)
//			@ShellOption() //arity = 3, defaultValue = "deffffff",  help = "Possi"
//					String text,
//			@ShellOption()
//					String text2
	) {
		Object[] s1 = {"aaa", "www"};

		List<User> ulist = new ArrayList<User>() {{
				add(new User("User1", new Department("Dep1"), Role.USER));
				add(new User("User2", new Department("Dep1"), Role.USER));
				add(new User("UserAdmin", new Department("Dep2"), Role.ADMIN));
		}};

		Object[][] oarr = ulist.stream()
				.map(u -> u.toStringsArray() )
				.toArray(size -> new Object[size][]);
		//StringsArray sa = u;

		Object[][] sampleData = new String[][] {
				{ "qq11", "qq12"},
				{ "qq21", "qq22"},
		};

		//sampleData[1] = u.toStringsArray();


		String[] headers = new String[] {"Property", "Value"};

		TableModel model = new ArrayTableModel(oarr);
		TableBuilder tableBuilder = new TableBuilder(model);
		tableBuilder.addInnerBorder(BorderStyle.fancy_light).addHeaderBorder(BorderStyle.fancy_double)
			.on(CellMatchers.column(0)).addWrapper(new KeyValueTextWrapper()).addSizer(new AbsoluteWidthSizeConstraints(20))
			.on(CellMatchers.column(1)).addSizer(new AbsoluteWidthSizeConstraints(30));
		//tableBuilder.on(CellMatchers.ofType(LocalDate.class)).addFormatter(dateFormatter);

		return tableBuilder.build().render(80);

		//Model model =
		//Helper.getPage(model, session, userService, 0, "", "");
		//return "Ok";//text + text2;
	}

}

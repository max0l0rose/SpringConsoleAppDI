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
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.jws.soap.SOAPBinding;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Stream;

@ShellComponent
public class AppCommand1
		//extends SecuredCommand
{
	private final Map<String,Object> session = new HashMap<>();

	@Autowired
	private UserService userService;

//	private final static String[][] headers = new String[][] {
//			{"Id", "UserName", "Department", "Role", "Created", "Modified" },
//	};


	@ShellMethod(key = {"commandc", "cc"}, value = "commandA descript...")
	public String commandA(
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

		//sampleData[1] = u.toStringsArray();

		Model model = new ExtendedModelMap();
		//model.addAttribute("qqq", 1);
		Helper.getPage(model, session, userService, 0, "id", "");

		List<User> uList = (List<User>)model.getAttribute("list");
		Object[][] headersAndData = Stream.concat(
					Arrays.stream(User.headers),
					uList.stream().map(u -> u.toStringsArray())
				)
				.toArray(size -> new Object[size][]);
//				.forEach(q -> {
//							Arrays.stream(q)
//									.forEach(a -> System.out.print(a + " "));
//							System.out.println(": " + Arrays.stream(q).count());
//						}
//				);


		TableModel tmodel = new ArrayTableModel(headersAndData);
		TableBuilder tableBuilder = new TableBuilder(tmodel);
		tableBuilder.addInnerBorder(BorderStyle.fancy_light).addHeaderBorder(BorderStyle.fancy_double)
			.on(CellMatchers.column(0)).addWrapper(new KeyValueTextWrapper()).addSizer(new AbsoluteWidthSizeConstraints(20))
			.on(CellMatchers.column(1)).addSizer(new AbsoluteWidthSizeConstraints(30))
			.on(CellMatchers.column(2)).addSizer(new AbsoluteWidthSizeConstraints(50));
		//tableBuilder.on(CellMatchers.ofType(LocalDate.class)).addFormatter(dateFormatter);

		return tableBuilder.build().render(80);
	}

}

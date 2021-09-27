package com.example.springconsoleappdi;

import com.example.springconsoleappdi.controller.Helper;
import com.example.springconsoleappdi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.table.ArrayTableModel;
import org.springframework.shell.table.BorderStyle;
import org.springframework.shell.table.TableBuilder;
import org.springframework.shell.table.TableModel;
import org.springframework.ui.Model;

import javax.validation.constraints.Size;
import java.util.HashMap;
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
		Object[][] sampleData = new String[][] {
				{ "qq11", "qq12"},
				{ "qq21", "qq22"},
		};

		TableModel model = new ArrayTableModel(sampleData);
		TableBuilder tableBuilder = new TableBuilder(model);
		tableBuilder.addInnerBorder(BorderStyle.fancy_light);

		return tableBuilder.build().render(80);

		//Model model =
		//Helper.getPage(model, session, userService, 0, "", "");
		//return "Ok";//text + text2;
	}

}

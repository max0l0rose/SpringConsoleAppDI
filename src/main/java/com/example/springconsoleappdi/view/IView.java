package com.example.springconsoleappdi.view;

import com.example.springconsoleappdi.model.StringsArray;
import com.example.springconsoleappdi.model.User;
import org.springframework.shell.table.*;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public interface IView {
	static String render(Model model) {
		List<StringsArray> uList = (List)model.getAttribute("list");
		String[][] headers = (String[][])model.getAttribute("headers");
//				.forEach(q -> {
//							Arrays.stream(q)
//									.forEach(a -> System.out.print(a + " "));
//							System.out.println(": " + Arrays.stream(q).count());
//						}
//				);

		Object[][] headersAndData = Stream.concat(
						Arrays.stream(headers),
						uList.stream().map(u -> u.toStringsArray())
				)
				.toArray(size -> new Object[size][]);

		TableModel tableModel = new ArrayTableModel(headersAndData);
		TableBuilder tableBuilder = new TableBuilder(tableModel);
		tableBuilder.addInnerBorder(BorderStyle.fancy_light).addHeaderBorder(BorderStyle.fancy_double)
				.on(CellMatchers.column(0)).addWrapper(new KeyValueTextWrapper()).addSizer(new AbsoluteWidthSizeConstraints(20))
				.on(CellMatchers.column(1)).addSizer(new AbsoluteWidthSizeConstraints(30))
				.on(CellMatchers.column(2)).addSizer(new AbsoluteWidthSizeConstraints(50));
		//tableBuilder.on(CellMatchers.ofType(LocalDate.class)).addFormatter(dateFormatter);

		return tableBuilder.build().render(80);
	}
}

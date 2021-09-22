package com.example.springconsoleappdi;

//import org.springframework.shell.commands.ConsoleCommands;
//import org.springframework.shell.core.annotation.CliCommand;
//import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

//@Component
//class MyCLI
//			extends ConsoleCommands
//			//implements CommandMarker
//{
//	@CliCommand(value = {"comA", "ca"})
//	public String commandA(
//			@CliOption(key = "p1") String p1) {
//		return p1;
//	}
//
////	@CliCommand(value = { "web-save", "ws" })
////	public String webSave(
////			@CliOption(key = "url") String url,
////			@CliOption(key = { "out", "file" }) String file)
////	{
////		String contents = getContentsOfUrlAsString(url);
////		try (PrintWriter out = new PrintWriter(file)) {
////			out.write(contents);
////		}
////		return "Done.";
////	}
//}

package com.example.springconsoleappdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.shell.Shell;
import org.springframework.shell.standard.ShellComponent;

import javax.persistence.*;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@SpringBootApplication(
//		exclude={DataSourceAutoConfiguration.class}
)
//@EnableAutoConfiguration()
@PropertySource("classpath:local.properties")
public class SpringConsoleAppDiApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringConsoleAppDiApplication.class);

	//@PersistenceContext(type = PersistenceContextType.EXTENDED)
	@Autowired
	private EntityManager entityManager;

	@PersistenceUnit
	EntityManagerFactory entityManFactory;

//	//@Autowired
//	//UsersRepo repository;
//
//	@Autowired
//	DepsRepo depsRepo;


//	//CommandLineRunner
//	@Bean
//	//@Transactional
//	public boolean demo(UsersRepo repository) {
//		//return (args) ->
//		//{
//		log.info("demo: ");
//
//			Department dep = new Department("dep");
//			depsRepo.save(dep);
//			dep.setDepName(dep.getDepName() + dep.getId());
//			depsRepo.save(dep);
//			//entityManager.merge(dep);
//
//			User user = new User("Jack", dep, Role.ADMIN);
//			repository.save(user);
////			// fetch all customers
//
////			log.info("Customers found with findAll():");
////			log.info("-------------------------------");
////			for (Customer customer : repository.findAll()) {
////				log.info(customer.toString());
////			}
////			log.info("");
////
////			// fetch an individual customer by ID
////			Customer customer = repository.findById(1L);
////			log.info("Customer found with findById(1L):");
////			log.info("--------------------------------");
////			log.info(customer.toString());
////			log.info("");
////
////			// fetch customers by last name
////			log.info("Customer found with findByLastName('Bauer'):");
////			log.info("--------------------------------------------");
////			repository.findByLastName("Bauer").forEach(bauer -> {
////				log.info(bauer.toString());
////			});
////			// for (Customer bauer : repository.findByLastName("Bauer")) {
////			//  log.info(bauer.toString());
////			// }
//			log.info("demo: Ok");
//		//};
//		return  true;
//	}


//	@Bean
//	public ApplicationRunner shellRunner(Shell shell) {
//		return new NonInteractiveShellRunner(shell);
//	}


//	@Order(0)
//	public class NonInteractiveShellRunner implements ApplicationRunner{
//
//		private final Shell shell;
//
//		public NonInteractiveShellRunner(Shell shell) {
//			this.shell = shell;
//		}
//
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			shell.run(new CommandInputProvider(args.getSourceArgs()));
//		}
//
//		public static class PredefinedInputProvider implements InputProvider{
//
//			private final Input input;
//			private boolean commandExecuted = false;
//
//			public PredefinedInputProvider(String[] args) {
//				this.input = new PredefinedInput(args);
//			}
//
//			@Override
//			public Input readInput() {
//				if (!commandExecuted){
//					commandExecuted=true;
//					return input;
//				}
//				return new PredefinedInput(new String[]{"exit"});
//			}
//
//			@AllArgsConstructor
//			private static class PredefinedInput implements Input{
//
//				private final String[] args;
//
//				@Override
//				public String rawText() {
//					return Seq.of(args).toString(" ");
//				}
//
//				@Override
//				public List<String> words(){
//					return Arrays.asList(args);
//				}
//			}
//
//		}
//
//	}
//

	public static void main(String[] args) {
		//List<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());

		//ZoneId id = ZoneId.of("Europe/Paris");
		//ZoneId id2 = ZoneId.of("Europe/Kiev"); // OK
		//ZoneOffset

//		LocalDateTime timePoint = LocalDateTime.now();     // The current date and time
//		int m = timePoint.getMonthValue();
//		LocalDateTime ldt2 = timePoint
//				.withMonth(m);
//				//.withDayOfMonth(10)
//				//.withYear(2010);
//
//		java.sql.Timestamp ts;
//
//		LocalDateTime foo = ldt2.with(lastDayOfMonth());
//		//int lastDay = foo.getDayOfMonth();

		//ZoneOffset zoneOffset = ZoneOffset.of("+2:00");

//		java.sql.Time stime = new Time(Instant.now());
//		//Instant.now();
		//java.sql.Date sdate;
		//java.util.Date ut;
//		java.util.Calendar cal;
//
//		Instant it;




//		Scanner in = new Scanner(System.in);
//		System.out.println("What is your name?");
//		String name = in.next();
//		System.out.println("Hello " + name + " welcome to spring boot" );
//
//		System.out.println("What is your height?");
//		int height = in.nextInt();
//		System.out.println(height);


//		Bootstrap bootstrap = new Bootstrap();
//		JLineShellComponent shell = bootstrap.getJLineShellComponent();
//		shell.executeCommand("help");

//		try {
//			Bootstrap.main(args);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		log.info("main: ----------------------------");
		try {
			SpringApplication.run(SpringConsoleAppDiApplication.class, args);
		} catch (IllegalStateException ex)
		{
			System.out.println(ex.getMessage());
		}
		log.info("main: ===========================!");


//		Console console = System.console();
//		String user = console.readLine("user: ");
//		String password = new String(console.readPassword("password: "));

	}

}

//@ShellComponent
//public class ClidemoPromptProvider{
//
//}



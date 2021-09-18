package com.example.springconsoleappdi;

import com.example.springconsoleappdi.model.Department;
import com.example.springconsoleappdi.model.Role;
import com.example.springconsoleappdi.model.User;
import com.example.springconsoleappdi.repo.DepsRepo;
import com.example.springconsoleappdi.repo.UsersRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@SpringBootApplication(
//		exclude={DataSourceAutoConfiguration.class}
)
//@EnableAutoConfiguration()
public class SpringConsoleAppDiApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringConsoleAppDiApplication.class);

	//@PersistenceContext(type = PersistenceContextType.EXTENDED)
	@Autowired
	private EntityManager entityManager;

	//@Autowired
	//UsersRepo repository;

	@Autowired
	DepsRepo depsRepo;


	//CommandLineRunner
	@Bean
	public boolean demo(UsersRepo repository) {
		//return (args) ->
		//{
		log.info("demo: ");

			Department dep = new Department("dep");
			depsRepo.save(dep);
			dep.setDepName(dep.getDepName() + dep.getId());
			depsRepo.save(dep);

			User user = new User("Jack", dep, Role.ADMIN);
			repository.save(user);
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
			log.info("demo: Ok");
		//};
		return  true;
	}


	public static void main(String[] args) {
		log.info("main: Start");
		SpringApplication.run(SpringConsoleAppDiApplication.class, args);
		log.info("main: Done!");
	}

}
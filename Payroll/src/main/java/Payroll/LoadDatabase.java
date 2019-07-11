package Payroll;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.logging.Logger; 
@Configuration
@Slf4j
class LoadDatabase {

  @Bean
	CommandLineRunner init(EmployeeRepository repository,OrderRepository orderRepository) {
		return args -> {
	    	Logger log = Logger.getLogger(LoadDatabase.class.getName()); 
			repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
			repository.save(new Employee("Bilbo", "Baggins", "burglar"));
			orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
			orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
			orderRepository.findAll().forEach(order -> {
				  log.info("Preloaded " + order);
				});
		};
  }
}
  
  

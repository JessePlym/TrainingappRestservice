package customer.rest.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import customer.rest.project.utils.FillDatabase;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertData(FillDatabase fillDatabase) {
		return (args) -> {
			fillDatabase.fill();
		};
	}

}

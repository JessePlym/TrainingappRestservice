package customer.rest.project.utils;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import customer.rest.project.domain.Customer;
import customer.rest.project.domain.CustomerRepository;
import customer.rest.project.domain.Training;
import customer.rest.project.domain.TrainingRepository;

@Component
public class FillDatabase {

	@Autowired
	private CustomerRepository cRepo;

	@Autowired
	private TrainingRepository tRepo;

	// fills database with test data
	public void fill() {

		// first delete everything
		cRepo.deleteAll();
		tRepo.deleteAll();

		Customer cust1 = new Customer("Jesse", "Plymander", "Kirvuntie", "02600", "Espoo", "j.p@mail.com",
				"0451101127");
		Customer cust2 = new Customer("Tikru", "Kissanen", "Asematie", "02700", "Kauniainen", "t.k@mail.com",
				"0451101128");

		// save all customers to repository
		cRepo.saveAll(Arrays.asList(cust1, cust2));

		Training train1 = new Training(LocalDateTime.now(), 60, "Running", cust1);

		// save all training with customer to repository
		tRepo.saveAll(Arrays.asList(train1));

	}

}

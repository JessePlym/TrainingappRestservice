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

		Customer cust1 = new Customer("Jesse", "Plymander", "Kirvuntie 1", "02600", "Espoo", "j.p@mail.com",
				"0451101127");
		Customer cust2 = new Customer("Tikru", "Kissanen", "Asematie 1", "02700", "Kauniainen", "t.k@mail.com",
				"0451101128");
		Customer cust3 = new Customer("Aliisa", "Gröna", "Puolakantie 19", "00540", "Helsinki", "a.g@mail.com",
				"0451101129");
		Customer cust4 = new Customer("Matti", "Meikäläinen", "Rauhankatu 82", "00840", "Helsinki", "m.m@mail.com",
				"0451101120");
		Customer cust5 = new Customer("Maija", "Meikäläinen", "Kluuvikatu 85", "01510", "Helsinki", "m.ma@mail.com",
				"0451101121");
		Customer cust6 = new Customer("Paula", "Mäkinen", "Piilostentie 64", "18100", "Heinola", "p.m@mail.com",
				"0451101122");
		Customer cust7 = new Customer("Paavo", "Nieminen", "Kartanomäenkatu 93", "78300", "Varkaus", "p.n@mail.com",
				"0451101123");
		Customer cust8 = new Customer("Karru", "Haddudi", "Pohjoisesplanadi 47", "00210", "Helsinki", "k.h@mail.com",
				"0451101124");
		Customer cust9 = new Customer("Mamo", "Haddudi", "Pohjoisesplanadi 47", "00210", "Helsinki", "m.h@mail.com",
				"0451101125");
		Customer cust10 = new Customer("Erkki", "Erakko", "Rautatienkatu 42", "88600", "Sotkamo", "e.e@mail.com",
				"0451101126");

		// save all customers to repository
		cRepo.saveAll(Arrays.asList(cust1, cust2, cust3, cust4, cust5, cust6, cust7, cust8, cust9, cust10));

		Training train1 = new Training(LocalDateTime.now(), 60, "Running", cust1);
		Training train2 = new Training(LocalDateTime.now().plusDays(1), 45, "Fitness", cust3);
		Training train3 = new Training(LocalDateTime.now().plusDays(2), 90, "Jogging", cust6);
		Training train4 = new Training(LocalDateTime.now().plusDays(3), 20, "HIIT", cust4);
		Training train5 = new Training(LocalDateTime.now().plusDays(1), 75, "Gym", cust1);
		Training train6 = new Training(LocalDateTime.now().plusDays(4), 25, "HIIT", cust7);
		Training train7 = new Training(LocalDateTime.now().plusDays(5), 50, "Fishing", cust10);

		// save all training with customer to repository
		tRepo.saveAll(Arrays.asList(train1, train2, train3, train4, train5, train6, train7));

	}

}

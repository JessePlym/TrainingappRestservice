package customer.rest.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import customer.rest.project.domain.Customer;
import customer.rest.project.domain.CustomerRepository;

@RestController
@CrossOrigin
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/customers")
	public @ResponseBody List<Customer> getCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

}

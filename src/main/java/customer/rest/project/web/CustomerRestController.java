package customer.rest.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import customer.rest.project.domain.Customer;
import customer.rest.project.domain.CustomerRepository;

@RestController
@CrossOrigin
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;

	// get all customers
	@GetMapping("/customers")
	public @ResponseBody List<Customer> getCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}

	// get single customer
	@GetMapping("/customers/{id}")
	public @ResponseBody Customer getSingleCustomer(@PathVariable(name = "id") Long id) {
		return (Customer) customerRepository.findById(id).get();
	}

	// save new customers
	@PostMapping("/customers")
	public void saveCustomers(@RequestBody List<Customer> customers) {
		customerRepository.saveAll(customers);
	}

	// delete one customer
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable(name = "id") Long id) {
		customerRepository.deleteById(id);
	}

	// TODO
	@PutMapping("/customers/{id}")
	public void editCustomer(@PathVariable(name = "id") Long id, @RequestBody Customer customer) {
		customerRepository.save(customer);
	}

}

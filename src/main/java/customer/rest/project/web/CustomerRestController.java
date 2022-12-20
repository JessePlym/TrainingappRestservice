package customer.rest.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import customer.rest.project.utils.FillDatabase;

@RestController
@CrossOrigin
public class CustomerRestController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private FillDatabase fillDatabase;

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

	// save new customer
	@PostMapping("/customers")
	public void saveCustomers(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}

	// delete one customer
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable(name = "id") Long id) {
		customerRepository.deleteById(id);
	}

	// edit one customer
	@PutMapping("/customers/{id}")
	public void editCustomer(@PathVariable(name = "id") Long id, @RequestBody Customer editCustomerDetails) {
		Customer updatedCustomer = customerRepository.findById(id).get();

		updatedCustomer.setFirstName(editCustomerDetails.getFirstName());
		updatedCustomer.setLastName(editCustomerDetails.getLastName());
		updatedCustomer.setStreetAddress(editCustomerDetails.getStreetAddress());
		updatedCustomer.setPostcode(editCustomerDetails.getPostcode());
		updatedCustomer.setCity(editCustomerDetails.getCity());
		updatedCustomer.setEmail(editCustomerDetails.getEmail());
		updatedCustomer.setPhone(editCustomerDetails.getPhone());

		customerRepository.save(updatedCustomer);

	}

	// resets the database to original test data
	@PostMapping("reset")
	public ResponseEntity<String> resetDatabase() {
		fillDatabase.fill();
		return ResponseEntity.ok().body("Reset done");
	}

}

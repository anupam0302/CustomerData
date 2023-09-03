package com.asr.customer.data;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.asr.customer.data.model.Customer;
import com.asr.customer.data.repository.CustomerRepositories;

@SpringBootTest
class CustomerDataApplicationTests {
	
	@Autowired
	private CustomerRepositories customerRepositories;

	@Test
	void createCustomerData() {
		Customer customer = new Customer();
		customer.setName("ARs");
		customer.setEmail("asr@sr.com");
		customerRepositories.save(customer);
	}
	
	@Test
	void deleteCustomerDataById() {
		int id = 1;
		customerRepositories.deleteById(id);
	}
	
	@Test
	void updateCustomerData() {
		Optional<Customer> customer = customerRepositories.findById(2);
		customer.ifPresent(c -> {
			c.setName("Anupam");
			c.setEmail("mail@update.in");
		});
		customerRepositories.save(customer.get());
	}
	
	@Test
	void retrieveCustomerData() {
		List<Customer> customer = customerRepositories.findAll();
		customer.forEach(c -> {
			System.out.println("id : "+c.getId()+" , name : "+c.getName()+" , email"+c.getEmail());
		});
	}

}

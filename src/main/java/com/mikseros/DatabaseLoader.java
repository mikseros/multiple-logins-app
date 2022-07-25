package com.mikseros;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mikseros.admin.User;
import com.mikseros.admin.UserRepository;
import com.mikseros.customer.Customer;
import com.mikseros.customer.CustomerRepository;

@Configuration
public class DatabaseLoader {

	private UserRepository userRepo;
	private CustomerRepository customerRepo;

	public DatabaseLoader(UserRepository userRepo, CustomerRepository customerRepo) {
		super();
		this.userRepo = userRepo;
		this.customerRepo = customerRepo;
	}

	@Bean
	public CommandLineRunner initializeDatabase() {
		return args -> {
			User user1 = new User("user@xxx.com", "123456");
			User user2 = new User("mark@xxx.com", "123456");
			
			userRepo.saveAll(List.of(user1, user2));
			
			Customer customer1 = new Customer("client1@xxx.com", "123456", "John Doe");
			Customer customer2 = new Customer("client2@xxx.com", "123456", "Jane Doe");
			
			customerRepo.saveAll(List.of(customer1, customer2));
			
			System.out.println("Sample database initialized");
		};
	}
}

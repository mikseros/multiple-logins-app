package com.mikseros;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

	private UserRepository repo;

	public DatabaseLoader(UserRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Bean
	public CommandLineRunner initializeDatabase() {
		return args -> {
			User user1 = new User("admin@xxx.com", "123456", Role.ADMIN);
			User user2 = new User("mark@xxx.com", "123456", Role.ADMIN);
			User user3 = new User("andy@xxx.com", "123456", Role.USER);
			User user4 = new User("mary@xxx.com", "123456", Role.USER);
			
			repo.saveAll(List.of(user1, user2, user3, user4));
			
			System.out.println("Sample database initialized");
		};
	}
}

package com.mikseros;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mikseros.admin.User;
import com.mikseros.admin.UserRepository;

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
			User user1 = new User("admin@xxx.com", "123456");
			User user2 = new User("mark@xxx.com", "123456");
			
			repo.saveAll(List.of(user1, user2));
			
			System.out.println("Sample database initialized");
		};
	}
}

package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.educandoweb.course.entits.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User( (long) 2, "Jose2", "Jose2@gmail.com", "988888888", "123456");
	
		userRepository.saveAll(Arrays.asList(u1));
	}
	
	
}

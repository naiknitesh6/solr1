package com.example.DecRedisPractise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@RestController
@OpenAPIDefinition(info = @Info(
        title = "Accounts",
        version = "0.0",
        description = "Nitesh!!!"))
@EnableCaching
public class DecRedisPractiseApplication {
	
	@Autowired
	private RedisRepo userRepository;
	@GetMapping("/getall")
	//@Cacheable(value="User",unless="#result.price>500")
	public Iterable<User> getUser()
	{
		return userRepository.findAll();
	}
	@GetMapping("/getByid/{id}")
	public Object getUser(@PathVariable int id)
	{
		return userRepository.findById(id);
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user)
	{
		return userRepository.save(user);
	}

	public static void main(String[] args) {
		SpringApplication.run(DecRedisPractiseApplication.class, args);
	}

}

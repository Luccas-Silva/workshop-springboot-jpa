package com.Stoico.course_Stoico.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Stoico.course_Stoico.entities.Category;
import com.Stoico.course_Stoico.entities.Order;
import com.Stoico.course_Stoico.entities.User;
import com.Stoico.course_Stoico.entities.enums.OrderStatus;
import com.Stoico.course_Stoico.repositories.CategoryRepository;
import com.Stoico.course_Stoico.repositories.OrderRepository;
import com.Stoico.course_Stoico.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Computers"); 
		Category cat3 = new Category(null, "Books");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Stoico", "stoico@gmail.com", "9999999", "1234567");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-10-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2022-10-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2022-11-22T15:21:22Z"), OrderStatus.SHIPPED, u3);
		Order o4 = new Order(null, Instant.parse("2022-11-24T06:45:18Z"), OrderStatus.DELIVERED, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
	} 

}

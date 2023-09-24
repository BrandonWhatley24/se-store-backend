package com.example.factory.SoftwareEngineering;
import com.example.factory.SoftwareEngineering.entity.Order;
import com.example.factory.SoftwareEngineering.entity.StoreItem;
import com.example.factory.SoftwareEngineering.entity.User;
import com.example.factory.SoftwareEngineering.repository.StoreItemRepository;
import com.example.factory.SoftwareEngineering.repository.UserRepository;
import com.example.factory.SoftwareEngineering.repository.orderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftwareEngineeringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngineeringApplication.class, args);
	}

	@Autowired
	private orderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StoreItemRepository storeItemRepository;

	@Override
	public void run(String... args) throws Exception{

		Order orderDetails1 = Order.builder()
				.itemTitle("Blue Shirt")
				.itemCat("Clothing")
				.itemSpecs("Blue")
				.purchaseDate("09-23-2023")
				.itemPrice(29.99)
				.build();

		Order orderDetails2 = Order.builder()
				.itemTitle("Red Shirt")
				.itemCat("Clothing")
				.itemSpecs("Red")
				.purchaseDate("09-23-2023")
				.itemPrice(32.99)
				.build();

		Order orderDetails3 = Order.builder()
				.itemTitle("Purple Shirt")
				.itemCat("Clothing")
				.itemSpecs("Purple")
				.purchaseDate("09-23-2023")
				.itemPrice(22.99)
				.build();

		orderRepository.save(orderDetails1);
		orderRepository.save(orderDetails2);
		orderRepository.save(orderDetails3);

		User user1 = User.builder()
				.firstName("Brandon")
				.lastName("Whatley")
				.username("brandon")
				.password("whatley")
				.build();

		User user2 = User.builder()
				.firstName("andrew")
				.lastName("mackey")
				.username("andrew")
				.password("mackey")
				.build();

		userRepository.save(user1);
		userRepository.save(user2);

		StoreItem si1 = StoreItem.builder()
				.itemTitle("Blue Shirt")
				.itemCat("Clothing")
				.itemSpecs("Blue")
				.itemPrice(29.99)
				.itemQty(20)
				.build();
		
		StoreItem si2 = StoreItem.builder()
				.itemTitle("Purple Shirt")
				.itemCat("Clothing")
				.itemSpecs("Purple")
				.itemPrice(22.99)
				.itemQty(20)
				.build();

		StoreItem si3 = StoreItem.builder()
				.itemTitle("Red Shirt")
				.itemCat("Clothing")
				.itemSpecs("Red")
				.itemPrice(32.99)
				.itemQty(20)
				.build();

		storeItemRepository.save(si1);
		storeItemRepository.save(si2);
		storeItemRepository.save(si3);
	}
}

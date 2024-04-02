package com.example.accessingdatajpa;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.util.Streamable;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository
			, CategoryRepository categoryRepository
			, MenuRepository menuRepository) {
		return (args) -> {

			//////////////////// 한식
			Category category = new Category();
			category.setName("한식");

			Menu menu1_1 = new Menu();
			menu1_1.setName("비빔밥");
			menu1_1.setCategory(category);

			Menu menu1_2 = new Menu();
			menu1_2.setName("콩나물국밥");
			menu1_2.setCategory(category);

//			Category category_1 = new Category();
//			category_1.setName("비빔밥");
//			category_1.setCategory(category);
//
//			Category category_2 = new Category();
//			category_2.setName("콩나물국밥");
//			category_2.setCategory(category);


			categoryRepository.save(category);
//			categoryRepository.save(category_1);
//			categoryRepository.save(category_2);
			menuRepository.save(menu1_1);
			menuRepository.save(menu1_2);

			//////////////////// 양식
			Category category2 = new Category();
			category2.setName("양식");

//			Category category2_1 = new Category();
//			category2_1.setName("스테이크");
//			category2_1.setCategory(category2);
//
//			Category category2_2 = new Category();
//			category2_2.setName("샐러드");
//			category2_2.setCategory(category2);

			Menu menu2_1 = new Menu();
			menu2_1.setName("스테이크");
			menu2_1.setCategory(category2);

			Menu menu2_2 = new Menu();
			menu2_2.setName("햄버거&샐러드");
			menu2_2.setCategory(category2);

			categoryRepository.save(category2);
//			categoryRepository.save(category2_1);
//			categoryRepository.save(category2_2);
			menuRepository.save(menu2_1);
			menuRepository.save(menu2_2);


			//////////////////// 중식
			Category category3 = new Category();
			category3.setName("중식");

//			Category category3_1 = new Category();
//			category3_1.setName("스테이크");
//			category3_1.setCategory(category3);
//
//			Category category3_2 = new Category();
//			category3_2.setName("샐러드");
//			category3_2.setCategory(category3);

			Menu menu3_1 = new Menu();
			menu3_1.setName("짜장면");
			menu3_1.setCategory(category3);

			Menu menu3_2 = new Menu();
			menu3_2.setName("짬뽕");
			menu3_2.setCategory(category3);

			categoryRepository.save(category3);
//			categoryRepository.save(category3_1);
//			categoryRepository.save(category3_2);
			menuRepository.save(menu3_1);
			menuRepository.save(menu3_2);


			//////////////////// 일식
			Category category4 = new Category();
			category4.setName("일식");

//			Category category4_1 = new Category();
//			category4_1.setName("돈까스&메밀");
//			category4_1.setCategory(category4);
//
//			Category category4_2 = new Category();
//			category4_2.setName("라멘");
//			category4_2.setCategory(category4);
			Menu menu4_1 = new Menu();
			menu4_1.setName("돈까스&메밀");
			menu4_1.setCategory(category4);

			Menu menu4_2 = new Menu();
			menu4_2.setName("라멘");
			menu4_2.setCategory(category4);

			categoryRepository.save(category4);
//			categoryRepository.save(category4_1);
//			categoryRepository.save(category4_2);
			menuRepository.save(menu4_1);
			menuRepository.save(menu4_2);





			// fetch all Category
			log.info("Category found with findAll():");
			log.info("-------------------------------");
			categoryRepository.findAll().forEach(category_ -> {
				log.info(category_.toString());
			});
			log.info("");

			// save a few customers
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));



			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");


			Iterable<Customer> iterable= repository.findAll();
			List<Customer> list = Streamable.of(iterable).toList();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Customer customer2 = (Customer) iterator.next();

				log.info("customer2", customer2.toString());
				log.info(customer2.toString());

			}


			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}

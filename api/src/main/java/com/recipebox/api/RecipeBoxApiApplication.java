package com.recipebox.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.recipebox.api.model.Category;
import com.recipebox.api.repository.CategoryRepository;

@SpringBootApplication
public class RecipeBoxApiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RecipeBoxApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RecipeBoxApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository repository) {
		return (args) -> {
			repository.save(new Category("Appetizers"));
			repository.save(new Category("Bread"));
			repository.save(new Category("Lunch"));

			for (Category category : repository.findAll()) {
				log.info("The application is: " + category.toString());
			}
		};
	}

}

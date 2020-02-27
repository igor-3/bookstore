package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository cRepository) {
		return (args) -> {
			log.info("save a couple of categories");
			cRepository.save(new Category("History"));
			cRepository.save(new Category("Novels"));
			log.info("save a couple of books");
			Book finnskogen = new Book("Finnskogen, elämän kehto", "Britt Karin Larsen", 2018, "978-952-312-696-1", 29.90, cRepository.findByName("Novels").get(0));
			Book scythians = new Book("The Scythians", "Barry Cunliffe", 2019, "978-0-19-882012-3", 34.90, cRepository.findByName("History").get(0));	
			repository.save(finnskogen);
			repository.save(scythians);
			scythians.setPrice(29.90);
			scythians.setTitle("The Scythians - Nomad Warriors of the Steppe");
			repository.save(scythians);

		};
	}

}

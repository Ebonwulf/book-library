package com.nology.booklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

@SpringBootApplication
public class BookLibraryApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(BookLibraryApplication.class, args);
		CsvConverter csvConverter = new CsvConverter();
		csvConverter.convertToJSON();
	}

}

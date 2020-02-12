package com.example.bookstore.domain;

import javax.persistence.Entity;

@Entity
public class Book {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private float price;
	
	public Book(String title, String author, int year, String isbn, float price) {
		
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
		
	}

}

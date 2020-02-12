package com.example.bookstore.web;

import org.springframework.web.bind.annotation.RequestMapping;


public class BookController {
	
	@RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

}

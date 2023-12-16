package com.example.bibliotecaCatalogo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class BibliotecaCatalogoApplication {


	public static void main(String[] args) {
		SpringApplication.run(BibliotecaCatalogoApplication.class, args);
	}

	/*@GetMapping(value = "/who/{user}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String who(@PathVariable("user") String user){
		return 	String.format("Hola!! el libro es %s y esta como un %s...:", user, role);

	}*/

}

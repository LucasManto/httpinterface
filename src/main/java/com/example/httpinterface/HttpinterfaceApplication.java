package com.example.httpinterface;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.httpinterface.clients.TodoClient;
import com.example.httpinterface.dtos.Todo;

@SpringBootApplication
public class HttpinterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpinterfaceApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(TodoClient todoClient) {
		return args -> {
			System.out.println(todoClient.get(1L));
			System.out.println(todoClient.todos());
			System.out.println(todoClient.create(new Todo(null, "My todo", false, 1L)));
		};
	}
}

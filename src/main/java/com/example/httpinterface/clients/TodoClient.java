package com.example.httpinterface.clients;

import java.util.List;

import com.example.httpinterface.dtos.Todo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/todos")
public interface TodoClient {
  
  @GetExchange
  List<Todo> todos();

  @GetExchange("/{todoId}")
  Todo get(@PathVariable("todoId") Long todoId);

  @PostExchange
  Todo create(@RequestBody Todo todo);
}

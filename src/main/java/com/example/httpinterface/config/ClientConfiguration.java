package com.example.httpinterface.config;

import com.example.httpinterface.clients.TodoClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfiguration {

  @Bean
  public HttpServiceProxyFactory factory() {
    WebClient webClient = WebClient.builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .build();
    return WebClientAdapter.createHttpServiceProxyFactory(webClient);
  }

  @Bean
  public TodoClient todoClient(HttpServiceProxyFactory factory) throws Exception {
    return factory.createClient(TodoClient.class);
  }
}

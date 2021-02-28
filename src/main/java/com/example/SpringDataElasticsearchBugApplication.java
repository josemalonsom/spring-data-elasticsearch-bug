package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class SpringDataElasticsearchBugApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataElasticsearchBugApplication.class, args);
	}

}

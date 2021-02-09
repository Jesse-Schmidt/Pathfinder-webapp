package com.pathfinder.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pathfinder.data")
@EntityScan("com.pathfinder.data.entities")
@ComponentScan({"com.pathfinder.restservice", "com.pathfinder.service"})
public class PathfinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathfinderApplication.class, args);
	}

}

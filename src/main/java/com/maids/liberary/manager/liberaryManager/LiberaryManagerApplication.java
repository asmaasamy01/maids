package com.maids.liberary.manager.liberaryManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.maids.liberary.manager.service","com.maids.liberary.manager.controller"})
@EnableJpaRepositories("com.maids.liberary.manager.data")
@EntityScan("com.maids.liberary.manager.data")
public class LiberaryManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiberaryManagerApplication.class, args);
	}

}

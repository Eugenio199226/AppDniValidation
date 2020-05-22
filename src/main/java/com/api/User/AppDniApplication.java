package com.api.User;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.Controller.ApiController;
import com.api.Repository.DniValidadorRepository;


import DniEntity.DniEntity;

@SpringBootApplication
//Se define la ubicación del controlador
@ComponentScan(basePackageClasses=ApiController.class)
//Se define la ubicación de la clase repositorio
@EnableJpaRepositories(basePackageClasses=DniValidadorRepository.class)
//Se define la ubicación de la clase entity
@EntityScan(basePackageClasses=DniEntity.class)
public class AppDniApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppDniApplication.class, args);
	}

}

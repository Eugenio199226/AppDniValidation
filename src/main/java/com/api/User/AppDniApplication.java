package com.api.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.api.Repository.DniValidadorRepository;
import com.api.controller.ApiController;
import com.api.entity.DniEntity;

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

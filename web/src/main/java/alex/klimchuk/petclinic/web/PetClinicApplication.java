package alex.klimchuk.petclinic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@SpringBootApplication
@EntityScan(basePackages = {"alex.klimchuk.petclinic.data.model"})
@EnableJpaRepositories(basePackages = {"alex.klimchuk.petclinic.data.repositories"})
@ComponentScan(basePackages = {"alex.klimchuk.petclinic.web", "alex.klimchuk.petclinic.data"})
public class PetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }

}

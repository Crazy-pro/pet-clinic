package alex.klimchuk.petclinic.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"alex.klimchuk.petclinic.web", "alex.klimchuk.petclinic.data"})
public class PetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicApplication.class, args);
    }

}

package alex.klimchuk.petclinic.web.configurations;

import guru.springframework.norris.chuck.ChuckNorrisInfoContributor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright Alex Klimchuk (c) 2022.
 */
@Configuration
public class ChuckNorrisConfiguration {

    @Bean
    public ChuckNorrisInfoContributor chuckNorrisInfoContributor() {
        return new ChuckNorrisInfoContributor();
    }

}

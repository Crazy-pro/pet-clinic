//package alex.klimchuk.petclinic.web.actuator.healthchecks;
//
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//
///**
// * Copyright Alex Klimchuk (c) 2022.
// */
//@Component
//public class CustomHealthIndicator implements HealthIndicator {
//
//    @Override
//    public Health health() {
//
//        Random random = new Random();
//
//        if(random.nextBoolean()){
//            return Health.down().withDetail("ERR-001", "Random failure").build();
//        }
//
//        return Health.up().build();
//    }
//
//}

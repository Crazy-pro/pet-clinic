//package alex.klimchuk.petclinic.web.actuator.endpoints;
//
//import org.springframework.boot.actuate.endpoints.AbstractEndpoint;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Copyright Alex Klimchuk (c) 2022.
// */
//@Component
//public class MyCustomEndpoint extends AbstractEndpoint<List<String>> {
//
//    public MyCustomEndpoint() {
//        super("mycustomendpoint");
//    }
//
//    @Override
//    public List<String> invoke() {
//
//        List<String> jamBands = new ArrayList<>(3);
//        jamBands.add("Dr Web");
//        jamBands.add("Alex");
//        jamBands.add("Mordor");
//
//        return jamBands;
//    }
//
//}

//package alex.klimchuk.petclinic.web.actuator.endpoints;
//
//import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Copyright Alex Klimchuk (c) 2022.
// */
//@Component
//public class CustomEndpoint extends AbstractEndpoint<List<String>> {
//
//    public CustomEndpoint() {
//        super("customEndpoint", false);
//    }
//
//    @Override
//    public List<String> invoke() {
//        List<String> list = new ArrayList<>(1);
//        list.add("Alex");
//        return list;
//    }
//
//}

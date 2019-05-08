package txb.test.coud.client2.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class Client1ServiceHystrix implements Client1Service {
    @Override
    public String sayHello(@RequestParam String param) {
        return "hello client1 id down";
    }
}

package txb.test.coud.client1.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class Client2ServiceHystrix implements Client2Service {
    @Override
    public String sayHello(@RequestParam String param) {
        return "hello client2 id down";
    }
}

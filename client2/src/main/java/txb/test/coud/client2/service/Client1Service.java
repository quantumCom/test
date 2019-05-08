package txb.test.coud.client2.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "client1",fallback = Client1ServiceHystrix.class)
public interface Client1Service {
    @RequestMapping(value = "/say-hello")
    public String sayHello(@RequestParam String param);
}

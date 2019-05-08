package txb.test.coud.client1.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "client2",fallback = Client2ServiceHystrix.class)
public interface Client2Service {
    @RequestMapping(value = "/say-hello")
    public String sayHello(@RequestParam String param);
}

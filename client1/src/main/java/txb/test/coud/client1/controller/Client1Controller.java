package txb.test.coud.client1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import txb.test.coud.client1.service.Client2Service;

import java.util.List;

@RestController
public class Client1Controller {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Client2Service client2Service;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/say-hello")
    public String sayHello() {
        return "i'm client1";
    }

    @RequestMapping("/contact-to-client2")
    public String client2() {
        return restTemplate.getForObject("http://" + "client2/say-hello?param=9", String.class);
    }

    @RequestMapping("/geign2client2")
    public String geign2client2() {
        return client2Service.sayHello("333");
    }

}

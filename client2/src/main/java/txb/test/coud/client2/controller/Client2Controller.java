package txb.test.coud.client2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import txb.test.coud.client2.service.Client1Service;

import java.util.List;

@RefreshScope
@RestController
public class Client2Controller {

    @Value("${value1}")
    private String value1;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private Client1Service client1Service;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return discoveryClient.getInstances(applicationName);
    }

    @RequestMapping("/config/value1")
    public String configValue1() {
        return value1;
    }

    @RequestMapping("/say-hello")
    public String sayHello(@RequestParam(required = false) String param) {
        return "i'm client2 with param:" + param;
    }

    @RequestMapping("/connect-to-client1")
    public String connect2Client1(@RequestParam(required = false) String param) {
        return client1Service.sayHello(param);
    }
}

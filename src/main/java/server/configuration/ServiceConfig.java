package server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import server.service.Service;

import java.util.Map;

@Configuration
public class ServiceConfig {

    @Autowired
    private Map<String, Service> serviceMap;


    public Service getService(String type) {
        return serviceMap.get(type);
    }
}

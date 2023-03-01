package server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import server.services.GeoService;

import java.util.Map;

@Configuration
public class ServiceConfig {

    @Autowired
    private Map<String, GeoService> serviceMap;


    public GeoService getService(String type) {
        return serviceMap.get(type);
    }
}

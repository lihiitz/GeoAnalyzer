package server.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import server.services.GeoService;

import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
public class ServiceConfig {

    private Map<String, GeoService> serviceMap;

    public GeoService getService(String type) {
        return serviceMap.get(type);
    }
}

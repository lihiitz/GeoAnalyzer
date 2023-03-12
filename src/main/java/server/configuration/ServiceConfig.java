package server.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import server.ServiceConverter;
import server.services.GeoService;

import java.util.Map;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Data
public class ServiceConfig {

   // @Autowired
    private Map<String, GeoService> serviceMap;

    public GeoService getService(String type) {
        return serviceMap.get(type);
    }
}

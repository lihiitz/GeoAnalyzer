package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import server.services.GeoService;

@Component
@ConfigurationPropertiesBinding
public class ServiceConverter implements Converter<String, GeoService> {
    @Autowired
    private ApplicationContext context;

    @Override
    public GeoService convert(String source) {
        GeoService service = null;
        try {
            service = (GeoService) context.getBean(Class.forName(source));
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return service;
    }
}

package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import server.services.GeoService;

@Component
public class ServiceConverter implements Converter<String, GeoService> {

    @Autowired
    private ApplicationContext context;
    @Override
    public GeoService convert(String source) {
        GeoService service = null;
        try {
            service = (GeoService) context.getBean(Class.forName(source), GeoService.class);
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return service;    }
}

package server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import server.Shape;

import java.util.Map;

@Configuration
public class ShapeConfig {

    @Autowired
    private Map<String, Shape> shapeMap;

    public Shape getShape(String type){
        return shapeMap.get(type);
    }
}

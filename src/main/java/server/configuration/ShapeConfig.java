package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ShapeConfig {

    @Autowired
    Map<String, Shape> shapeMap;

    public Shape getSahpe(String type){
        return shapeMap.get(type);
    }
}

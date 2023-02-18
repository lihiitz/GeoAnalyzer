package server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("geoJson")
public class GeoJsonService implements IService {

    @Autowired
    private Map<String, IShape> shapeMap;

    @Override
    public int numOfVertices(String geo) {

        GeoJson geoJson = null;
        try {
            geoJson = new ObjectMapper().readValue(geo, GeoJson.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return shapeMap.get(geoJson.getType()).numOfVertices(geoJson);
    }
}

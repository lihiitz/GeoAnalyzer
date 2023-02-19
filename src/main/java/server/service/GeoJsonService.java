package server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.geoRequest;
import server.IShape;

import java.util.Map;

@Service("geoJson")
public class GeoJsonService implements IService {

    @Autowired
    private Map<String, IShape> shapeMap;

    private geoRequest getGeoJson(String geo) {
        geoRequest geoJson = null;
        try {
            geoJson = new ObjectMapper().readValue(geo, geoRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return geoJson;
    }

    @Override
    public int numOfVertices(String geo) {
        return shapeMap.get(getGeoJson(geo).getType()).numOfVertices(getGeoJson(geo));
    }

    @Override
    public int numOfPoints(String geo) {
        return shapeMap.get(getGeoJson(geo).getType()).numOfPoints(getGeoJson(geo));
    }
}

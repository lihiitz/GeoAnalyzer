//package server.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import server.geoRequest;
//import server.shapes.Shape;
//
//import java.util.Map;
//
//@org.springframework.stereotype.Service("geoJson")
//public class GeoJsonService implements Service {
//
//    @Autowired
//    private Map<String, Shape> shapeMap;
//
//    private geoRequest getGeoJson(String geo) {
//        geoRequest geoJson = null;
//        try {
//            geoJson = new ObjectMapper().readValue(geo, geoRequest.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return geoJson;
//    }
//
//    @Override
//    public int numOfVertices(String geo) {
//        return shapeMap.get(getGeoJson(geo).getType()).numOfVertices(getGeoJson(geo));
//    }
//
//    @Override
//    public int numOfPoints(String geo) {
//        return shapeMap.get(getGeoJson(geo).getType()).numOfPoints(getGeoJson(geo));
//    }
//}

package server.services;

import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wololo.jts2geojson.GeoJSONReader;
import server.model.response.PointsResponse;
import server.configuration.ShapeConfig;
import server.model.response.DimensionsResponse;

@Service
public class GeoJsonService implements GeoService {

    @Autowired
    private ShapeConfig shapeConfig;

    @Autowired
    private GeoJSONReader reader;
    @Override
    public DimensionsResponse numOfDimensions(String geo) {
        Geometry geometry = reader.read(geo);
        int numOfVertices = shapeConfig.getShape(geometry.getGeometryType()).numOfVertices(geometry);

        return DimensionsResponse.builder()
                .numOfVertices(numOfVertices)
                .build();
    }

    @Override
    public PointsResponse numOfPoints(String geo) {
        Geometry geometry = reader.read(geo);
        int numOfPoints = shapeConfig.getShape(geometry.getGeometryType()).numOfPoints(geometry);

        return PointsResponse.builder()
                .numOfPoints(numOfPoints)
                .build();
    }
}

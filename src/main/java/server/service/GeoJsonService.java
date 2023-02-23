//package server.service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import server.geoRequest;
//import server.Shape;
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

package server.service;

import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.wololo.jts2geojson.GeoJSONReader;
import server.configuration.ShapeConfig;

@org.springframework.stereotype.Service("geoJson")
public class GeoJsonService implements Service {

    @Autowired
    private ShapeConfig shapeConfig;

    @Override
    public int numOfVertices(String geo) {
        Geometry geometry = convertToGeometry(geo);
        return shapeConfig.getShape(geometry.getGeometryType()).numOfVertices(geometry);
    }

    @Override
    public int numOfPoints(String geo) {
        Geometry geometry = convertToGeometry(geo);
        return shapeConfig.getShape(geometry.getGeometryType()).numOfPoints(geometry);
    }


    private Geometry convertToGeometry(String geo) {
        GeoJSONReader reader = new GeoJSONReader();
        return reader.read(geo);
    }
}

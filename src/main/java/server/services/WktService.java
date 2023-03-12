package server.services;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.response.NumOfPointsResponse;
import server.configuration.ShapeConfig;
import server.model.response.NumOfVerticesResponse;

@Service("geo/wkt")
public class WktService implements GeoService {

    @Autowired
    private ShapeConfig shapeConfig;

    private Geometry convertToGeometry(String geo){
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        WKTReader wktReader = new WKTReader(geometryFactory);
        Geometry geometry = null;
        try {
            geometry = wktReader.read(geo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return geometry;
    }
    public NumOfVerticesResponse numOfVertices(String geo) {
        Geometry geometry = convertToGeometry(geo);
        int numOfVertices = shapeConfig.getShape(geometry.getGeometryType()).numOfVertices(geometry);

        return NumOfVerticesResponse.builder()
                .numOfVertices(numOfVertices)
                .build();
    }

    @Override
    public NumOfPointsResponse numOfPoints(String geo) {
        Geometry geometry = convertToGeometry(geo);
        int numOfPoints = shapeConfig.getShape(geometry.getGeometryType()).numOfPoints(geometry);

        return NumOfPointsResponse.builder()
                .numOfPoints(numOfPoints)
                .build();
    }
}

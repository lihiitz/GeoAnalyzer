package server.services;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.model.response.PointsResponse;
import server.configuration.ShapeConfig;
import server.model.response.DimensionsResponse;

@Service
public class WktService implements GeoService {

    @Autowired
    private ShapeConfig shapeConfig;
    @Autowired
    private WKTReader wktReader;

    private Geometry convertToGeometry(String geo){
        Geometry geometry = null;
        try {
            geometry = wktReader.read(geo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return geometry;
    }
    public DimensionsResponse numOfDimensions(String geo) {
        Geometry geometry = convertToGeometry(geo);

        int numOfVertices = shapeConfig.getShape(geometry.getGeometryType()).numOfVertices(geometry);

        return DimensionsResponse.builder()
                .numOfDimensions(numOfVertices)
                .build();
    }

    @Override
    public PointsResponse numOfPoints(String geo) {
        Geometry geometry = convertToGeometry(geo);
        int numOfPoints = shapeConfig.getShape(geometry.getGeometryType()).numOfPoints(geometry);

        return PointsResponse.builder()
                .numOfPoints(numOfPoints)
                .build();
    }
}

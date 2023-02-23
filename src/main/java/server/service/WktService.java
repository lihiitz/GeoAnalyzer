package server.service;


import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import server.configuration.ShapeConfig;

@org.springframework.stereotype.Service("wkt")
public class WktService implements Service {

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
    public int numOfVertices(String geo) {
        Geometry geometry = convertToGeometry(geo);
        return shapeConfig.getShape(geometry.getGeometryType()).numOfVertices(geometry);
    }

    @Override
    public int numOfPoints(String geo) {
        Geometry geometry = convertToGeometry(geo);
        return shapeConfig.getShape(geometry.getGeometryType()).numOfPoints(geometry);
    }
}

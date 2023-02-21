package server;

import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("Polygon")
public class Polygon implements Shape {

    @Override
    public int numOfVertices(Geometry geo) {

        Polygon polygon = 
//        List<Object> l1 = geoJson.getCoordinates();
//        int sum = 0;
//
//        for (Object object: l1) {
//            List<List<Double>> l2 = (List<List<Double>>) object;
//            sum += l2.size() - 1;
//        }
//        return sum;
        return 0;
    }

    @Override
    public int numOfPoints(Geometry geo) {
        return geo.getNumPoints();
    }
}

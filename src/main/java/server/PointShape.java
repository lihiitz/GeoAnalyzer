package server;

import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Component;

@Component("Point")
public class Point implements Shape {

    @Override
    public int numOfVertices(Geometry geo) {
        return 1;
    }

    @Override
    public int numOfPoints(Geometry geo) {
        return geo.getNumPoints();
    }
}

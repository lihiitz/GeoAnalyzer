package server.shapes;

import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Component;

@Component("Point")
public class PointShape extends BaseShape {

    private static final int NUM_OF_VERTICES = 1;

    @Override
    public int numOfVertices(Geometry geo) {
        return NUM_OF_VERTICES;
    }
}

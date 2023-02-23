package server;

import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Component;

@Component("Point")
public class PointShape extends BaseShape {

    @Override
    public int numOfVertices(Geometry geo) {
        return 1;
    }
}

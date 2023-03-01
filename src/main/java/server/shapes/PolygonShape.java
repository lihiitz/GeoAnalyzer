package server.shapes;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.springframework.stereotype.Component;

@Component("Polygon")
public class PolygonShape extends BaseShape {

    @Override
    public int numOfVertices(Geometry geo) {

        Polygon polygon = (Polygon) geo;

        int sum = polygon.getExteriorRing().getNumPoints() - 1;

        for (int i = 0; i < polygon.getNumInteriorRing(); i++) {
            sum += polygon.getInteriorRingN(i).getNumPoints() - 1;
        }

        return sum;
    }
}

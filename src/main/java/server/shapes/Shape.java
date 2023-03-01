package server.shapes;

import org.locationtech.jts.geom.Geometry;

public interface Shape {

    int numOfVertices(Geometry geo);

    int numOfPoints(Geometry geo);
}

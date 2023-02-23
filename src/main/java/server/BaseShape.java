package server;

import org.locationtech.jts.geom.Geometry;

public abstract class BaseShape implements Shape{

    public int numOfPoints(Geometry geo){
        return geo.getNumPoints();
    }
}

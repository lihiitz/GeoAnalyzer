package server;

import org.springframework.stereotype.Component;

@Component("LineString")
public class Line implements IShape {

    @Override
    public int numOfVertices(GeoJson geoJson) {
        return 2;
    }
}

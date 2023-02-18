package server;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("Polygon")
public class Polygon implements IShape {

    @Override
    public int numOfVertices(GeoJson geoJson) {

        List<Object> l1 = geoJson.getCoordinates();
        int sum = 0;

        for (Object object: l1) {
            List<List<Float>> l2 = (List<List<Float>>) object;
            sum += l2.size() - 1;
        }


        return sum;
    }
}

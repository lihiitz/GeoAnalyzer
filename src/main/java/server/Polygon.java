package server;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("Polygon")
public class Polygon implements IShape {

    @Override
    public int numOfVertices(geoRequest geoJson) {

        List<Object> l1 = geoJson.getCoordinates();
        int sum = 0;

        for (Object object: l1) {
            List<List<Double>> l2 = (List<List<Double>>) object;
            sum += l2.size() - 1;
        }
        return sum;
    }

    @Override
    public int numOfPoints(geoRequest geoJson) {
        List<Object> l1 = geoJson.getCoordinates();
        int sum = 0;

        for (Object object: l1) {
            List<List<Double>> l2 = (List<List<Double>>) object;
            sum += l2.size();
        }
        return sum;    }
}

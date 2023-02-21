package server;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.LineString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("LineString")
public class Line implements Shape {

    private boolean isPointOnStraightLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate the slopes of the lines between the first two points and the second two points
        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y3 - y2) / (x3 - x2);

        // Compare the slopes to determine if the three points are collinear
        return slope1 == slope2;
    }
    @Override
    public int numOfVertices(Geometry geo) {
//        if(geoJson.getCoordinates().size() == 2){
//            return 2;
//        }
//
//        List<Object> coordinates = geoJson.getCoordinates();
//        // [ [2, 1], [3, 4], ...[5,6] ]
//        int sum = 1;
//        for (int i = 0; i < coordinates.size() - 2; i++){
//            List<Double> point0 = (List<Double>)coordinates.get(i);
//            List<Double> point1 = (List<Double>)coordinates.get(i + 1);
//            List<Double> point2 = (List<Double>)coordinates.get(i + 2);
//            if (!isPointOnStraightLine(point0.get(0), point0.get(1), point1.get(0), point1.get(1), point2.get(0), point2.get(1))){
//                sum++;
//            }
//        }
//        return sum + 1;
        return 0;
    }

    @Override
    public int numOfPoints(Geometry geo) {
        return geo.getNumPoints();
    }
}

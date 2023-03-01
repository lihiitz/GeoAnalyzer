package server.shapes;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("LineString")
public class LineShape extends BaseShape {

    private boolean isPointOnStraightLine(double x1, double y1, double x2, double y2, double x3, double y3) {
        // Calculate the slopes of the lines between the first two points and the second two points
        double slope1 = (y2 - y1) / (x2 - x1);
        double slope2 = (y3 - y2) / (x3 - x2);

        // Compare the slopes to determine if the three points are collinear
        return slope1 == slope2;
    }

    @Override
    public int numOfVertices(Geometry geo) {
        Coordinate[] coordinates = geo.getCoordinates();
        if (coordinates.length == 2) {
            return 2;
        }
        int sum = 1;
        List<Coordinate> coords = new ArrayList<>(Arrays.asList(coordinates));

        for (int i = 0; i < coords.size() - 2; i++) {
            Coordinate coord1 = coords.get(i);
            Coordinate coord2 = coords.get(i + 1);
            Coordinate coord3 = coords.get(i + 2);

            if (!isPointOnStraightLine(coord1.x, coord1.y, coord2.x, coord2.y, coord3.x, coord3.y)) {
                sum++;
            }
        }
        return sum + 1;
    }
}
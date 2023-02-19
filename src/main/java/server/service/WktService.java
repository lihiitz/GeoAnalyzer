package server.service;


import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.PrecisionModel;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;

@Service("wkt")
public class WktService implements IService {

//    @Autowired
//    private Map<String, IShape> shapeMap;
//    @Override
//    public int numOfVertices(String geo) {
//
//        GeoJson geoJson = new GeoJson();
//        String[] split1 = geo.split("\\(", 2);
//        List<String> listOfPointsAsString = new ArrayList<>();
//        Arrays.stream(split1[1].split("\\),\\(")).forEach(x -> listOfPointsAsString.add(x.replaceAll("[()]", "")));
//
//
//        if (split1[0].equals("POINT")) {
//            List<Double> res = new ArrayList<>();
//            String[] s1 = listOfPointsAsString.get(0).split(" ");
//            res.add(Double.parseDouble(s1[0]));
//            res.add(Double.parseDouble(s1[1]));
//            geoJson.setCoordinates(Collections.singletonList(res));
//            geoJson.setType("Point");
//
//        } else if (split1[0].equals("LINESTRING")) {
//            List<List<Double>> res = new ArrayList<>();
//            for (String pointsAsString : listOfPointsAsString) {
//                String[] split2 = pointsAsString.split(",");
//                for (String s : split2) {
//                    String[] s1 = s.split(" ");
//                    List<Double> point = new ArrayList<>();
//                    point.add(Double.parseDouble(s1[0]));
//                    point.add(Double.parseDouble(s1[1]));
//                    res.add(point);
//                }
//            }
//            geoJson.setType("LineString");
//            geoJson.setCoordinates(Collections.singletonList(res));
//        } else {//POLYGON
//            List<List<List<Double>>> res = new ArrayList<>();
//            for (String pointsAsString : listOfPointsAsString) {
//                String[] split2 = pointsAsString.split(",");
//                List<List<Double>> listOfPoints = new ArrayList<>();
//                for (String s : split2) {
//                    String[] s1 = s.split(" ");
//                    List<Double> point = new ArrayList<>();
//                    point.add(Double.parseDouble(s1[0]));
//                    point.add(Double.parseDouble(s1[1]));
//                    listOfPoints.add(point);
//                }
//                res.add(listOfPoints);
//            }
//            geoJson.setCoordinates(Collections.singletonList(res));
//
//            geoJson.setType("Polygon");
//        }

    public int numOfVertices(String geo) {
        GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 4326);
        WKTReader wktReader = new WKTReader(geometryFactory);
        Geometry geometry = null;
        try {
            geometry = wktReader.read(geo);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String geometryType = geometry.getGeometryType();
        Coordinate[] geometryCoordinates = geometry.getCoordinates();


        return 0;
    }

    @Override
    public int numOfPoints(String geo) {
        return 0;
    }
}

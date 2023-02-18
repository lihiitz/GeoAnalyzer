package server;

import org.springframework.stereotype.Service;

@Service("wkt")
public class WktService implements IService {

    @Override
    public int numOfVertices(String geo) {

        String[] split = geo.split("\\(", 2);

        GeoJson geoJson = new GeoJson();
        geoJson.setType(split[0]);
      //  String[] coordinates = split[1].split("")
        return 0;
    }
}

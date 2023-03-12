package server;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.configuration.ServiceConfig;
import server.model.response.NumOfPointsResponse;
import server.model.response.NumOfVerticesResponse;

@RestController
@RequestMapping
@Slf4j
@AllArgsConstructor
public class GeoAnalyzerController {

    private static final String CONTENT_TYPE = "Content-Type";
    @Autowired
    private ServiceConfig serviceConfiguration;

    @PostMapping("/dimensions")
    public NumOfVerticesResponse numOfVertices(@RequestBody String geo, @RequestHeader (name = CONTENT_TYPE) String geoTpe) {
        return serviceConfiguration.getService(geoTpe).numOfVertices(geo);
    }

    @PostMapping("/points")
    public NumOfPointsResponse numOfPoints(@RequestBody String geo, @RequestHeader (name = CONTENT_TYPE) String geoTpe) {
        return serviceConfiguration.getService(geoTpe).numOfPoints(geo);
    }
}

package server;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.configuration.ServiceConfig;
import server.model.response.NumOfPointsResponse;
import server.model.response.NumOfVerticesResponse;

@RestController
@RequestMapping("geo-analyzer")
@Slf4j
@AllArgsConstructor
public class GeoAnalyzerController {

    @Autowired
    private ServiceConfig serviceConfiguration;

    @PostMapping("/dimensions")
    public NumOfVerticesResponse numOfVertices(@RequestBody String geo, @RequestHeader String geoType) {
        return serviceConfiguration.getService(geoType).numOfVertices(geo);
    }

    @PostMapping("/points")
    public NumOfPointsResponse numOfPoints(@RequestBody String geo, @RequestHeader String geoType) {
        return serviceConfiguration.getService(geoType).numOfPoints(geo);
    }
}

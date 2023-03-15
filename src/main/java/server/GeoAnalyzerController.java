package server;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import server.configuration.ServiceConfig;
import server.model.response.PointsResponse;
import server.model.response.DimensionsResponse;

@RestController
@RequestMapping
@AllArgsConstructor
public class GeoAnalyzerController {
    private static final String CONTENT_TYPE = "Content-Type";

    @Autowired
    private ServiceConfig serviceConfiguration;
    @Autowired
    private ApplicationContext context;

    @PostMapping("/dimensions")
    public DimensionsResponse numOfDimensions(@RequestBody String geo, @RequestHeader(name = CONTENT_TYPE) String geoType) {
        return serviceConfiguration.getService(geoType).numOfDimensions(geo);
    }

    @PostMapping("/points")
    public PointsResponse numOfPoints(@RequestBody String geo, @RequestHeader(name = CONTENT_TYPE) String geoType) {
        return serviceConfiguration.getService(geoType).numOfPoints(geo);
    }
}

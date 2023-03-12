package server.services;

import server.model.response.PointsResponse;
import server.model.response.DimensionsResponse;

public interface GeoService {

    DimensionsResponse numOfDimensions(String geo);

    PointsResponse numOfPoints(String geo);
}

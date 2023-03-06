package server.services;

import server.model.response.NumOfPointsResponse;
import server.model.response.NumOfVerticesResponse;

public interface GeoService {

    NumOfVerticesResponse numOfVertices(String geo);

    NumOfPointsResponse numOfPoints(String geo);
}

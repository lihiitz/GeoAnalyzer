package server.model.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PointsResponse {

    private int numOfPoints;
}

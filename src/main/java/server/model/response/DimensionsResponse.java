package server.model.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class DimensionsResponse {

    private int numOfDimensions;
}

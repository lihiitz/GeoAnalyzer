package server.model.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class NumOfVerticesResponse {

    private int numOfVertices;
}

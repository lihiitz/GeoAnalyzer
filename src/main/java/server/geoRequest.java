package server;

import lombok.Data;

import java.util.List;

@Data
public class geoRequest {

    private String type;
    private List<Object> coordinates;
}

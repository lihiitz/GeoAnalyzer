package server;

import lombok.Data;

import java.util.List;

@Data
public class GeoJson {

    private String type;
    private List<Object> coordinates;
}

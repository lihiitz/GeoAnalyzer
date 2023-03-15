package server.services;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class GeoJsonServiceTest {

    @Autowired
    private GeoJsonService service;

    private String createInput(String type, String coords) {
        return "{\"type\": \"" + type + "\", \"coordinates\": " + coords + "}";
    }

    @Test
    public void whenInsertInvalidInputToGetNumOfPoint_throwIllegalArgumentException() {
        String input = createInput("invalidInput", "[102.0]");
        assertThrows(IllegalArgumentException.class, () -> service.numOfPoints(input).getNumOfPoints());
    }

    @Test
    public void whenInsertInvalidInputToGetNumOfDimensions_throwIllegalArgumentException() {
        String input = createInput("invalidInput", "[102.0]");
        assertThrows(IllegalArgumentException.class, () -> service.numOfDimensions(input).getNumOfDimensions());
    }
    @Test
    public void whenInsertValidPoint_returnNumOfPoints() {
        String input = createInput(Geometry.TYPENAME_POINT, "[102.0, 0.5]");
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(1);
    }

    @Test
    public void whenInsertValidPoint_returnNumOfDimensions() {
        String input = createInput(Geometry.TYPENAME_POINT, "[102.0, 0.5]");
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(1);
    }

    @Test
    public void whenInsertValidLineString_returnNumOfPoints() {
        String input = createInput(Geometry.TYPENAME_LINESTRING,
                "[[1.0, 1.0], [2.0, 1.0], [3.0, 0.0], [4.0, 1.0], [5.0, 2.0], [6.0, 3.0], [7.0, 3.0], [6.0, 2.0]]");
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(8);
    }

    @Test
    public void whenInsertValidLineString_returnNumOfDimensions() {
        String input = createInput(Geometry.TYPENAME_LINESTRING,
                "[[1.0, 1.0], [2.0, 1.0], [3.0, 0.0], [4.0, 1.0], [5.0, 2.0], [6.0, 3.0], [7.0, 3.0], [6.0, 2.0]]");
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(6);
    }

    @Test
    public void whenInsertValidPolygon_returnNumOfPoints() {
        String input = createInput(Geometry.TYPENAME_POLYGON,
                "[[[0.5, 0.5], [5.0, 0.0], [5.5, 5.0], [0.0, 5.0], [0.5, 0.5]], [[1.5, 1.0], [4.0, 3.0], [4.0, 1.0], [1.5, 1.0]]]");
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(9);
    }

    @Test
    public void whenInsertValidPolygon_returnNumOfDimensions() {
        String input = createInput(Geometry.TYPENAME_POLYGON,
                "[[[0.5, 0.5], [5.0, 0.0], [5.5, 5.0], [0.0, 5.0], [0.5, 0.5]], [[1.5, 1.0], [4.0, 3.0], [4.0, 1.0], [1.5, 1.0]]]");
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(7);
    }
}
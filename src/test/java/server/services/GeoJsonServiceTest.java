package server.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.model.response.DimensionsResponse;
import server.model.response.PointsResponse;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GeoJsonServiceTest {

    @Autowired
    private GeoJsonService service;

    private static final String POINT = "Point";
    private static final String LINE_STRING = "LineString";
    private static final String POLYGON = "Polygon";

    private String createInput(String type, String coords) {
        return "{\"type\": \"" + type + "\", \"coordinates\": " + coords + "}";
    }

    @Test
    public void pointGetNumOfPoints() {
        String input = createInput(POINT, "[102.0, 0.5]");
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(1);
    }

    @Test
    public void pointGetNumOfDimensions() {
        String input = createInput(POINT, "[102.0, 0.5]");
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(1);
    }

    @Test
    public void lineStringGetNumOfPoints() {
        String input = createInput(LINE_STRING,
                "[[1.0, 1.0], [2.0, 1.0], [3.0, 0.0], [4.0, 1.0], [5.0, 2.0], [6.0, 3.0], [7.0, 3.0], [6.0, 2.0]]");
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(8);
    }

    @Test
    public void lineStringGetNumOfDimensions() {
        String input = createInput(LINE_STRING,
                "[[1.0, 1.0], [2.0, 1.0], [3.0, 0.0], [4.0, 1.0], [5.0, 2.0], [6.0, 3.0], [7.0, 3.0], [6.0, 2.0]]");
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(6);
    }

    @Test
    public void polygonGetNumOfPoints() {
        String input = createInput(POLYGON,
                "[[[0.5, 0.5], [5.0, 0.0], [5.5, 5.0], [0.0, 5.0], [0.5, 0.5]], [[1.5, 1.0], [4.0, 3.0], [4.0, 1.0], [1.5, 1.0]]]");
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(9);
    }

    @Test
    public void polygonGetNumOfDimensions() {
        String input = createInput(POLYGON,
                "[[[0.5, 0.5], [5.0, 0.0], [5.5, 5.0], [0.0, 5.0], [0.5, 0.5]], [[1.5, 1.0], [4.0, 3.0], [4.0, 1.0], [1.5, 1.0]]]");
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(7);
    }
}
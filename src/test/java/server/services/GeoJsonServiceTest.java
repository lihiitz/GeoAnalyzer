package server.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GeoJsonServiceTest {

    @Autowired
    private GeoJsonService service;
    // TODO: 01/03/2023 Autowired or new ?

    private String createInput(String type, String coords) {

        return "{\"type\": \"" + type + "\", \"coordinates\": " + coords + "}";
    }

    @Test
    public void pointGetNumOfPoints() {
        assertThat(service.numOfPoints(createInput("Point", "[102.0, 0.5]"))
                .getNumOfPoints()).isEqualTo(1);
    }

    @Test
    public void pointGetNumOfVertices() {
        assertThat(service.numOfVertices(createInput("Point", "[102.0, 0.5]"))
                .getNumOfVertices()).isEqualTo(1);
    }

    @Test
    public void lineStringGetNumOfPoints() {
        assertThat(service.numOfPoints(createInput(
                "LineString", "[[1.0, 1.0], [2.0, 1.0], [3.0, 0.0], [4.0, 1.0], [5.0, 2.0], [6.0, 3.0], [7.0, 3.0], [6.0, 2.0]]"))
                .getNumOfPoints()).isEqualTo(8);
    }

    @Test
    public void lineStringGetNumOfVertices() {
        assertThat(service.numOfVertices(createInput(
                "LineString", "[[1.0, 1.0], [2.0, 1.0], [3.0, 0.0], [4.0, 1.0], [5.0, 2.0], [6.0, 3.0], [7.0, 3.0], [6.0, 2.0]]"))
                .getNumOfVertices()).isEqualTo(6);
    }

    @Test
    public void polygonGetNumOfPoints() {
        assertThat(service.numOfPoints(createInput(
                "Polygon", "[[[0.5, 0.5], [5.0, 0.0], [5.5, 5.0], [0.0, 5.0], [0.5, 0.5]], [[1.5, 1.0], [4.0, 3.0], [4.0, 1.0], [1.5, 1.0]]]"))
                .getNumOfPoints()).isEqualTo(9);
    }

    @Test
    public void polygonGetNumOfVertices() {
        assertThat(service.numOfVertices(createInput(
                "Polygon", "[[[0.5, 0.5], [5.0, 0.0], [5.5, 5.0], [0.0, 5.0], [0.5, 0.5]], [[1.5, 1.0], [4.0, 3.0], [4.0, 1.0], [1.5, 1.0]]]"))
                .getNumOfVertices()).isEqualTo(7);
    }
}
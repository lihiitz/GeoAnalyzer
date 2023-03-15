package server.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WktServiceTest {

    @Autowired
    private WktService service;

    @Test
    public void pointGetNumOfPoints() {
        String input = "POINT(0.5 0.5)";
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(1);
    }

    @Test
    public void pointGetNumOfDimensions() {
        String input = "POINT(0.5 0.5)";
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(1);
    }

    @Test
    public void lineStringGetNumOfPoints() {
        String input = "LINESTRING(1.0 1.0, 2.0 1.0, 3.0 0.0, 4.0 1.0, 5.0 2.0, 6.0 3.0, 7.0 3.0, 6.0 2.0)";
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(8);
    }

    @Test
    public void lineStringGetNumOfDimensions() {
        String input = "LINESTRING(1.0 1.0, 2.0 1.0, 3.0 0.0, 4.0 1.0, 5.0 2.0, 6.0 3.0, 7.0 3.0, 6.0 2.0)";
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(6);
    }

    @Test
    public void polygonGetNumOfPoints() {
        String input = "POLYGON((0.5 0.5,5 0,5 5,0 5,0.5 0.5),(1.5 1,4 3,4 1,1.5 1))";
        int numOfPoints = service.numOfPoints(input).getNumOfPoints();
        assertThat(numOfPoints).isEqualTo(9);
    }

    @Test
    public void polygonGetNumOfDimensions() {
        String input = "POLYGON((0.5 0.5,5 0,5 5,0 5,0.5 0.5),(1.5 1,4 3,4 1,1.5 1))";
        int numOfDimensions = service.numOfDimensions(input).getNumOfDimensions();
        assertThat(numOfDimensions).isEqualTo(7);
    }
}
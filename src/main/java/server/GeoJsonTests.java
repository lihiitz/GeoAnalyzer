package server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.service.WktService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class WktTests {

    @Autowired
    private WktService service;

    @Test
    public void pointGetNumOfPoints() {
        assertThat(service.numOfPoints("POINT(0.5 0.5)")).isEqualTo(1);
    }

    @Test
    public void pointGetNumOfVertices() {
        assertThat(service.numOfVertices("POINT(0.5 0.5)")).isEqualTo(1);
    }

    @Test
    public void lineStringGetNumOfPoints() {
        assertThat(service.numOfPoints("LINESTRING(1.0 1.0, 2.0 1.0, 3.0 0.0, 4.0 1.0, 5.0 2.0, 6.0 3.0, 7.0 3.0, 6.0 2.0)")).isEqualTo(8);
    }

    @Test
    public void lineStringGetNumOfVertices() {
        assertThat(service.numOfVertices("LINESTRING(1.0 1.0, 2.0 1.0, 3.0 0.0, 4.0 1.0, 5.0 2.0, 6.0 3.0, 7.0 3.0, 6.0 2.0)")).isEqualTo(6);
    }

    @Test
    public void polygonGetNumOfPoints() {
        assertThat(service.numOfPoints("POLYGON((0.5 0.5,5 0,5 5,0 5,0.5 0.5),(1.5 1,4 3,4 1,1.5 1))")).isEqualTo(9);
    }

    @Test
    public void polygonGetNumOfVertices() {
        assertThat(service.numOfVertices("POLYGON((0.5 0.5,5 0,5 5,0 5,0.5 0.5),(1.5 1,4 3,4 1,1.5 1))")).isEqualTo(7);
    }
}

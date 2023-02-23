package server;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GeoAnalyzerTests {

    @Autowired
    private GeoAnalyzerController controller;

    @Test
    public void getNumOfPoints() {
        int i = controller.numOfPoints("POLYGON((0.5 0.5,5 0,5 5,0 5,0.5 0.5),(1.5 1,4 3,4 1,1.5 1))", "wkt");
        int l = 0;
    }
}

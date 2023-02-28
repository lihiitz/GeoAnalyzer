package server.test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import server.service.GeoJsonService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GeoJsonTests {

    @Autowired
    private GeoJsonService service;

    private JSONObject getJsonObject(String type, JSONArray arr) {
        JSONObject json = new JSONObject();
        json.put("type", type);
        json.put("coordinates", arr);
        return json;
    }

    @Test
    public void pointGetNumOfPoints() {
        assertThat(service.numOfPoints(getJsonObject("Point", new JSONArray().put(0.5).put(100.0)).toString())).isEqualTo(1);
    }

    @Test
    public void pointGetNumOfVertices() {
        assertThat(service.numOfVertices(getJsonObject("Point", new JSONArray().put(0.5).put(100.0)).toString())).isEqualTo(1);
    }

    @Test
    public void lineStringGetNumOfPoints() {
        assertThat(service.numOfPoints(getJsonObject("LineString",
                new JSONArray().put(new JSONArray().put(1.0).put(1.0)).put(new JSONArray().put(2.0).put(1.0)).put(new JSONArray().put(3.0).put(0.0)).put(new JSONArray().put(4.0).put(1.0)).put(new JSONArray().put(5.0).put(2.0)).put(new JSONArray().put(6.0).put(3.0)).put(new JSONArray().put(7.0).put(3.0)).put(new JSONArray().put(6.0).put(2.0)))
                .toString())).isEqualTo(8);
    }

    @Test
    public void lineStringGetNumOfVertices() {
        assertThat(service.numOfVertices(getJsonObject("LineString",
                new JSONArray().put(new JSONArray().put(1.0).put(1.0)).put(new JSONArray().put(2.0).put(1.0)).put(new JSONArray().put(3.0).put(0.0)).put(new JSONArray().put(4.0).put(1.0)).put(new JSONArray().put(5.0).put(2.0)).put(new JSONArray().put(6.0).put(3.0)).put(new JSONArray().put(7.0).put(3.0)).put(new JSONArray().put(6.0).put(2.0)))
                .toString())).isEqualTo(6);
    }

    @Test
    public void polygonGetNumOfPoints() {
        JSONArray outer1 = new JSONArray().put(new JSONArray().put(0.5).put(0.5)).put(new JSONArray().put(5.0).put(0.0)).put(new JSONArray().put(5.5).put(5.0)).put(new JSONArray().put(0.0).put(5.0)).put(new JSONArray().put(0.5).put(0.5));
        JSONArray outer2 = new JSONArray().put(new JSONArray().put(1.5).put(1.0)).put(new JSONArray().put(4.0).put(3.0)).put(new JSONArray().put(4.0).put(1.0)).put(new JSONArray().put(1.5).put(1.0));

        assertThat(service.numOfPoints(getJsonObject("Polygon",
                new JSONArray().put(outer1).put(outer2))
                .toString())).isEqualTo(9);
    }

    @Test
    public void polygonGetNumOfVertices() {
        JSONArray outer1 = new JSONArray().put(new JSONArray().put(0.5).put(0.5)).put(new JSONArray().put(5.0).put(0.0)).put(new JSONArray().put(5.5).put(5.0)).put(new JSONArray().put(0.0).put(5.0)).put(new JSONArray().put(0.5).put(0.5));
        JSONArray outer2 = new JSONArray().put(new JSONArray().put(1.5).put(1.0)).put(new JSONArray().put(4.0).put(3.0)).put(new JSONArray().put(4.0).put(1.0)).put(new JSONArray().put(1.5).put(1.0));

        assertThat(service.numOfVertices(getJsonObject("Polygon",
                new JSONArray().put(outer1).put(outer2))
                .toString())).isEqualTo(7);
    }
}

package server.configuration;

import org.locationtech.jts.io.WKTReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wololo.jts2geojson.GeoJSONReader;

@Configuration
public class ReaderConfiguration {

    @Bean
    public WKTReader getWktReader(){
        return new WKTReader();
    }

    @Bean
    public GeoJSONReader getGeoJsonReader(){
        return new GeoJSONReader();
    }
}

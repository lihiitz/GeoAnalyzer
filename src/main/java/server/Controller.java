package server;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("geo-analyzer")
@Slf4j
@AllArgsConstructor
public class Controller {

    @Autowired
    private Map<String, IService> serviceMap;

    @PostMapping("/dimensions")
    int numOfVertices(@RequestBody String geo, @RequestHeader String header) {
        return serviceMap.get(header).numOfVertices(geo);
    }
}

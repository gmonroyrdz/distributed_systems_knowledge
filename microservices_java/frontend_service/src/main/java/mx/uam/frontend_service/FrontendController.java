package mx.uam.frontend_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import mx.uam.frontend_service.entities.SensorData;

@RestController
@RequestMapping("/api")
public class FrontendController {
    
    @Value("${STORAGE_URL}")
    private String storageUrl;
    
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{neighborhood}")
    public List<SensorData> getNeighborhoodData(@PathVariable String neighborhood) {
        String url = storageUrl + "/" + neighborhood;
        return restTemplate.getForObject(url, List.class);
    }
}
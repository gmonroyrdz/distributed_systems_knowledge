package mx.uam.storage_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.storage_service.entities.SensorData;

@RestController
@RequestMapping("/data")
public class StorageController {
    @Autowired
    private SensorDataRepository repository;

    @PostMapping
    public ResponseEntity<Void> storeData(@RequestBody SensorData data) {
        repository.save(data);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{neighborhood}")
    public List<SensorData> getDataByNeighborhood(@PathVariable String neighborhood) {
        return repository.findTop10ByNeighborhoodOrderByTimestampDesc(neighborhood);
    }
}

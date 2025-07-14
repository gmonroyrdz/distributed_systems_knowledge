package mx.uam.collector_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.collector_service.entities.SensorData;

@RestController
@RequestMapping("/collector")
public class CollectorController {
    @Autowired
    private DataDispacher dataDispacher;

    @PostMapping("/collect")
    public ResponseEntity<Void> collectSensorData(@RequestBody SensorData sensorData) {
        dataDispacher.dispatch(sensorData);
        return ResponseEntity.ok().build();
    }
}

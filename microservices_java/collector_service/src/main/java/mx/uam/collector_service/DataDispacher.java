package mx.uam.collector_service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.uam.collector_service.entities.SensorData;

@Component
public class DataDispacher {
    @Value("${STORAGE_URL}")
    private String storageUrl;

    @Value("${ALERTS_URL}")
    private String alertsUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public void dispatch(SensorData sensorData) {
        // Envio asíncrono de datos al servicio storage
        CompletableFuture.runAsync(() -> {
            restTemplate.postForObject(storageUrl, sensorData, Void.class);
        });

        // Envio asíncrono de datos al servicio alerts
        CompletableFuture.runAsync(() -> {
            restTemplate.postForObject(alertsUrl, sensorData, Void.class);
        });
    }
}

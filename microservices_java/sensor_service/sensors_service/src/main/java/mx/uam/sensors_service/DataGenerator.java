package mx.uam.sensors_service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import mx.uam.sensors_service.entities.SensorData;

@Component
@EnableScheduling
public class DataGenerator {
    @Value("${COLLECTOR_URL}")
    private String collectorUrl;

    @Value("${NEIGHBORHOOD}")
    private String neighborhood;
private final Random random = new Random();
private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 5000)
    public void generateData() {
        double temperature = 15 + (25 - 15) * random.nextDouble();
        double humidity = 30 + (70 - 30) * random.nextDouble();
        double airQuality = 50 + (100 - 50) * random.nextDouble();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        SensorData sensorData = new SensorData(neighborhood, temperature, humidity, airQuality, timestamp);
        restTemplate.postForObject(collectorUrl + "/collect", sensorData, Void.class);
    }
}

package mx.uam.alert_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mx.uam.alert_service.entities.SensorData;

@Service
public class AlertService {
    private static final Logger log = LoggerFactory.getLogger(AlertService.class);

    public void checkAlerts(SensorData data) {
        if(data.getTemperature() > 35){
            log.warn("Alerta de temperatura alta en el vecindario: " + data.getNeighborhood() + " con temperatura: " + data.getTemperature());
        }
        if(data.getHumidity() > 200){
            log.warn("Alerta de humedad alta en el vecindario: " + data.getNeighborhood() + " con humedad: " + data.getHumidity());
        }
    }
}

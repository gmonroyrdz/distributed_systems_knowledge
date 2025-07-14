package mx.uam.alert_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.alert_service.entities.SensorData;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private  AlertService alertService;

   @PostMapping
   public ResponseEntity<Void> checkAlert(@RequestBody SensorData data)
   {
         alertService.checkAlerts(data);
         return ResponseEntity.ok().build();
   }

}

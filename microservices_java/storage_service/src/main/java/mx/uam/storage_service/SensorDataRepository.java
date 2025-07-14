package mx.uam.storage_service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.uam.storage_service.entities.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findTop10ByNeighborhoodOrderByTimestampDesc(String neighborhood);
}

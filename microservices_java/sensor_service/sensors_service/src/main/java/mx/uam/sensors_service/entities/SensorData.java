package mx.uam.sensors_service.entities;

public class SensorData {
    private String neighborhood;
    private double temperature;
    private double humidity;
    private double airQuality;
    private String timestamp;
    
    public SensorData(String neighborhood, double temperature, double humidity, double airQuality, String timestamp) {
        this.neighborhood = neighborhood;
        this.temperature = temperature;
        this.humidity = humidity;
        this.airQuality = airQuality;
        this.timestamp = timestamp;
    }
    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getAirQuality() {
        return airQuality;
    }

    public void setAirQuality(double airQuality) {
        this.airQuality = airQuality;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    @Override
    public String toString() {
        return "SensorData{" +
                "neighborhood='" + neighborhood + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", airQuality=" + airQuality +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

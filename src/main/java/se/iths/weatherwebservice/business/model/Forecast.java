package se.iths.weatherwebservice.business.model;

public class Forecast {
    String origin;
    Double temp;
    Double humidity;
    String timestamp;

    public Forecast(String origin, Double temp, Double humidity, String timestamp) {
        this.origin = origin;
        this.temp = temp;
        this.humidity = humidity;
        this.timestamp = timestamp;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

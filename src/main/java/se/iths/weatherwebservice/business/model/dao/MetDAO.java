package se.iths.weatherwebservice.business.model.dao;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se.iths.weatherwebservice.business.model.met.MetWeather;

public class MetDAO {
    static WebClient client = WebClient.create();
    public MetWeather getMetWeather() {
        try {
            Mono<MetWeather> mono = client
                    .get()
                    .uri("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.3110&lon=18.0300")
                    .retrieve()
                    .bodyToMono(MetWeather.class);

            return mono.block();

        } catch (Exception e){
            return null;
        }
    }

    public Double getNextDayTemperature() {
        return getMetWeather().getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getAirTemperature().doubleValue();
    }

    public Double getNextDayHumidity() {
        return getMetWeather().getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getRelativeHumidity().doubleValue();
    }
}

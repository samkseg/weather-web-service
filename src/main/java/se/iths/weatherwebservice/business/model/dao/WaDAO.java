package se.iths.weatherwebservice.business.model.dao;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se.iths.weatherwebservice.business.model.wa.WaWeather;

import java.time.LocalTime;

public class WaDAO {
    static WebClient client = WebClient.create();
    public WaWeather getWaWeather() {
        try {
            Mono<WaWeather> mono = client
                    .get()
                    .uri("https://api.weatherapi.com/v1/forecast.json?key=dbd13e849b924885b1d213827231005&q=59.3110,18.0300&days=2&aqi=no&alerts=no")
                    .retrieve()
                    .bodyToMono(WaWeather.class);

            return mono.block();

        } catch (Exception e) {
            return null;
        }
    }

    public Double getNextDayTemperature() {
        Integer hour = LocalTime.now().getHour();
        return getWaWeather().getForecast().getForecastday().get(1).getHour().get(hour).getTempC().doubleValue();
    }

    public Double getNextDayHumidity() {
        Integer hour = LocalTime.now().getHour();
        return getWaWeather().getForecast().getForecastday().get(1).getHour().get(hour).getHumidity().doubleValue();
    }
}

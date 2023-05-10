package se.iths.weatherwebservice.model.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se.iths.weatherwebservice.model.met.MetWeather;
import se.iths.weatherwebservice.model.smhi.SmhiWeather;
import se.iths.weatherwebservice.model.wa.WaWeather;

import java.time.LocalTime;

@Service
public class WebService {
    static WebClient client = WebClient.create();

    public SmhiWeather getSmhiWeather(){
        try {
            Mono<SmhiWeather> mono = client
                    .get()
                    .uri("https://opendata-download-metfcst.smhi.se/api/category/pmp3g/version/2/geotype/point/lon/18.0300/lat/59.3110/data.json")
                    .retrieve()
                    .bodyToMono(SmhiWeather.class);

            return mono.block();

        } catch (Exception e){
            return null;
        }
    }

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

    public WaWeather getWaWeather() {
        try {
            Mono<WaWeather> mono = client
                    .get()
                    .uri("https://api.weatherapi.com/v1/forecast.json?key=dbd13e849b924885b1d213827231005&q=59.3110,18.0300&days=2&aqi=no&alerts=no")
                    .retrieve()
                    .bodyToMono(WaWeather.class);

            return mono.block();

        } catch (Exception e){
            return null;
        }
    }

    public Integer getNextDayTemperature(SmhiWeather smhiWeather) {
        return Math.toIntExact(smhiWeather.getTimeSeries().get(24).getParameters().get(10).getValues().get(0));
    }

    public Integer getNextDayTemperature(MetWeather metWeather) {
        return Math.toIntExact(metWeather.getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getAirTemperature().intValue());
    }

    public Integer getNextDayTemperature(WaWeather waWeather) {
        Integer hour = LocalTime.now().getHour();
        System.out.println(hour);
        return Math.toIntExact(waWeather.getForecast().getForecastday().get(1).getHour().get(hour).getTempC().intValue());
    }
}

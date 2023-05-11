package se.iths.weatherwebservice.business.model.dao;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import se.iths.weatherwebservice.business.model.smhi.SmhiWeather;

public class SmhiDAO {
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
}

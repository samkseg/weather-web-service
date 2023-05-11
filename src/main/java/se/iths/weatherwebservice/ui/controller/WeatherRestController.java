package se.iths.weatherwebservice.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se.iths.weatherwebservice.business.service.WebService;

@RestController
public class WeatherRestController {

    @Autowired
    WebService webService;

    @GetMapping("/rs/temp")
    public Integer getTemp() {
        return webService.getNextDayTemperature();
    }

    @GetMapping("/rs/humid")
    public Double getHumid() {
        return webService.getNextDayHumidity();
    }
}

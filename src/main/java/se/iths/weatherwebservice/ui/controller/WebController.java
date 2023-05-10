package se.iths.weatherwebservice.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.weatherwebservice.model.met.MetWeather;
import se.iths.weatherwebservice.model.service.WebService;
import se.iths.weatherwebservice.model.smhi.SmhiWeather;
import se.iths.weatherwebservice.model.wa.WaWeather;

@Controller
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping("/forecast")
    public String getForecast(Model model) {
        SmhiWeather smhiWeather = webService.getSmhiWeather();
        MetWeather metWeather = webService.getMetWeather();
        WaWeather waWeather = webService.getWaWeather();
        model.addAttribute("temp", webService.getNextDayTemperature(smhiWeather, metWeather, waWeather));

        return "forecast";
    }
}

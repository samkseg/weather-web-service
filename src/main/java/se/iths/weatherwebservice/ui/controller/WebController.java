package se.iths.weatherwebservice.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.iths.weatherwebservice.business.service.WebService;

@Controller
public class WebController {

    @Autowired
    WebService webService;

    @GetMapping("/forecast")
    public String getForecast(Model model) {
        model.addAttribute("forecast", webService.getForecast());
        model.addAttribute("date", webService.getForecastDate());
        model.addAttribute("time", webService.getForecastTime());
        return "forecast";
    }
}

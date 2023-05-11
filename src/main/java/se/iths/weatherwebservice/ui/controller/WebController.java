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
        model.addAttribute("date", webService.getDate());
        model.addAttribute("time", webService.getTime());
        model.addAttribute("temp", webService.getNextDayTemperature());
        model.addAttribute("humid", webService.getNextDayHumidity());
        return "forecast";
    }
}

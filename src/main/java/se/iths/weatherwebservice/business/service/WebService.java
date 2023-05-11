package se.iths.weatherwebservice.business.service;

import org.springframework.stereotype.Service;
import se.iths.weatherwebservice.business.model.Forecast;
import se.iths.weatherwebservice.business.model.dao.MetDAO;
import se.iths.weatherwebservice.business.model.dao.SmhiDAO;
import se.iths.weatherwebservice.business.model.dao.WaDAO;
import se.iths.weatherwebservice.business.model.met.MetWeather;
import se.iths.weatherwebservice.business.model.smhi.SmhiWeather;
import se.iths.weatherwebservice.business.model.wa.WaWeather;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class WebService {

    SmhiDAO smhiDAO = new SmhiDAO();
    MetDAO metDAO = new MetDAO();
    WaDAO waDAO = new WaDAO();

    public Double getNextDayTemperature(){
        List<Double> list = new ArrayList<>();
        list.add(smhiDAO.getNextDayTemperature());
        list.add(metDAO.getNextDayTemperature());
        list.add(waDAO.getNextDayTemperature());
        return Collections.max(list);
    }

    public Double getNextDayHumidity() {
        List<Double> list = new ArrayList<>();
        list.add(smhiDAO.getNextDayHumidity());
        list.add(metDAO.getNextDayHumidity());
        list.add(waDAO.getNextDayHumidity());
        return Math.round(list.stream().mapToDouble((x) -> x).summaryStatistics().getAverage() * 10) / 10.0;
    }

    public String getForecastDate() {
        return LocalDate.now().plusDays(1).toString();
    }

    public String getForecastTime() {
        return LocalTime.parse(LocalTime.now().toString()).truncatedTo( ChronoUnit.HOURS).toString();
    }

    public String getTimeStamp() {
        String date = LocalDate.now().toString();
        String time = LocalTime.parse(LocalTime.now().toString()).truncatedTo( ChronoUnit.MINUTES).toString();
        return date + " " + time;
    }

    public Forecast getForecast() {
        Double dSmhi = smhiDAO.getNextDayTemperature();
        Double dMet = metDAO.getNextDayTemperature();
        Double dWa = waDAO.getNextDayTemperature();

        Double highestTemp = Collections.max(List.of(dSmhi, dMet, dWa));
        String source = "";
        double humidity = 0.0;
        String timestamp = getTimeStamp();

        if (highestTemp.equals(dWa)) {
            source = "WeatherAPI.com";
            humidity = waDAO.getNextDayHumidity();
        }
        if (highestTemp.equals(dMet)) {
            source = "MET.no";
            humidity = metDAO.getNextDayHumidity();
        }
        if (highestTemp.equals(dSmhi)) {
            source = "SMHI.se";
            humidity = smhiDAO.getNextDayHumidity();
        }
        return new Forecast(source, highestTemp, humidity, timestamp);
    }
}

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
        Integer hour = LocalTime.now().getHour();
        List<Double> list = new ArrayList<>();
        list.add(smhiDAO.getSmhiWeather().getTimeSeries().get(24).getParameters().get(1).getValues().get(0).doubleValue());
        list.add(metDAO.getMetWeather().getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getAirTemperature().doubleValue());
        list.add(waDAO.getWaWeather().getForecast().getForecastday().get(1).getHour().get(hour).getTempC().doubleValue());
        return Collections.max(list);
    }

    public Double getNextDayHumidity() {
        Integer hour = LocalTime.now().getHour();
        List<Double> list = new ArrayList<>();
        list.add(smhiDAO.getSmhiWeather().getTimeSeries().get(24).getParameters().get(5).getValues().get(0).doubleValue());
        list.add(metDAO.getMetWeather().getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getRelativeHumidity().doubleValue());
        list.add(waDAO.getWaWeather().getForecast().getForecastday().get(1).getHour().get(hour).getHumidity().doubleValue());
        return Math.round(list.stream().mapToDouble((x) -> x).summaryStatistics().getAverage() * 10) / 10.0;
    }

    public String getForecastDate() {
        return LocalDate.now().plusDays(1).toString();
    }

    public String getForecastTime() {
        return LocalTime.parse(LocalTime.now().toString()).truncatedTo( ChronoUnit.HOURS).toString();
    }

    public Forecast getForecast() {
        Integer hour = LocalTime.now().getHour();
        String date = LocalDate.now().toString();
        String time = LocalTime.parse(LocalTime.now().toString()).truncatedTo( ChronoUnit.MINUTES).toString();

        SmhiWeather smhiWeather = smhiDAO.getSmhiWeather();
        MetWeather metWeather = metDAO.getMetWeather();
        WaWeather waWeather = waDAO.getWaWeather();

        Double dSmhi = smhiWeather.getTimeSeries().get(24).getParameters().get(1).getValues().get(0).doubleValue();
        Double dMet = metWeather.getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getAirTemperature().doubleValue();
        Double dWa = waWeather.getForecast().getForecastday().get(1).getHour().get(hour).getTempC().doubleValue();

        Double highestTemp = Collections.max(List.of(dSmhi, dMet, dWa));
        String source = "";
        double humidity = 0.0;
        String timestamp = date + " " + time;

        if (highestTemp.equals(dWa)) {
            source = "WeatherAPI.com";
            humidity = waWeather.getForecast().getForecastday().get(1).getHour().get(hour).getHumidity().doubleValue();
        }
        if (highestTemp.equals(dMet)) {
            source = "MET.no";
            humidity = metWeather.getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getRelativeHumidity().doubleValue();
        }
        if (highestTemp.equals(dSmhi)) {
            source = "SMHI.se";
            humidity = smhiWeather.getTimeSeries().get(24).getParameters().get(5).getValues().get(0).doubleValue();
        }
        return new Forecast(source, highestTemp, humidity, timestamp);
    }
}

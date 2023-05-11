package se.iths.weatherwebservice.business.service;

import org.springframework.stereotype.Service;
import se.iths.weatherwebservice.business.model.dao.MetDAO;
import se.iths.weatherwebservice.business.model.dao.SmhiDAO;
import se.iths.weatherwebservice.business.model.dao.WaDAO;

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

    public Integer getNextDayTemperature(){
        Integer hour = LocalTime.now().getHour();
        List<Integer> list = new ArrayList<>();
        list.add(Math.toIntExact(smhiDAO.getSmhiWeather().getTimeSeries().get(24).getParameters().get(1).getValues().get(0)));
        list.add(Math.toIntExact(metDAO.getMetWeather().getProperties().getTimeseries().get(25).getData().getInstant().getDetails().getAirTemperature().intValue()));
        list.add(Math.toIntExact(waDAO.getWaWeather().getForecast().getForecastday().get(1).getHour().get(hour).getTempC().intValue()));
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

    public String getDate() {
        String date = LocalDate.now().plusDays(1).toString();
        return date;
    }

    public String getTime() {
        return LocalTime.parse(LocalTime.now().toString()).truncatedTo( ChronoUnit.HOURS).toString();
    }
}

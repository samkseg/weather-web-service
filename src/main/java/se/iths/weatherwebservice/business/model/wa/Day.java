
package se.iths.weatherwebservice.business.model.wa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "maxtemp_c",
    "maxtemp_f",
    "mintemp_c",
    "mintemp_f",
    "avgtemp_c",
    "avgtemp_f",
    "maxwind_mph",
    "maxwind_kph",
    "totalprecip_mm",
    "totalprecip_in",
    "totalsnow_cm",
    "avgvis_km",
    "avgvis_miles",
    "avghumidity",
    "daily_will_it_rain",
    "daily_chance_of_rain",
    "daily_will_it_snow",
    "daily_chance_of_snow",
    "condition",
    "uv"
})
public class Day {

    @JsonProperty("maxtemp_c")
    private Double maxtempC;
    @JsonProperty("maxtemp_f")
    private Double maxtempF;
    @JsonProperty("mintemp_c")
    private Double mintempC;
    @JsonProperty("mintemp_f")
    private Double mintempF;
    @JsonProperty("avgtemp_c")
    private Double avgtempC;
    @JsonProperty("avgtemp_f")
    private Double avgtempF;
    @JsonProperty("maxwind_mph")
    private Double maxwindMph;
    @JsonProperty("maxwind_kph")
    private Double maxwindKph;
    @JsonProperty("totalprecip_mm")
    private Double totalprecipMm;
    @JsonProperty("totalprecip_in")
    private Double totalprecipIn;
    @JsonProperty("totalsnow_cm")
    private Double totalsnowCm;
    @JsonProperty("avgvis_km")
    private Double avgvisKm;
    @JsonProperty("avgvis_miles")
    private Double avgvisMiles;
    @JsonProperty("avghumidity")
    private Double avghumidity;
    @JsonProperty("daily_will_it_rain")
    private Long dailyWillItRain;
    @JsonProperty("daily_chance_of_rain")
    private Long dailyChanceOfRain;
    @JsonProperty("daily_will_it_snow")
    private Long dailyWillItSnow;
    @JsonProperty("daily_chance_of_snow")
    private Long dailyChanceOfSnow;
    @JsonProperty("condition")
    private Condition__1 condition;
    @JsonProperty("uv")
    private Double uv;

    @JsonProperty("maxtemp_c")
    public Double getMaxtempC() {
        return maxtempC;
    }

    @JsonProperty("maxtemp_c")
    public void setMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
    }

    @JsonProperty("maxtemp_f")
    public Double getMaxtempF() {
        return maxtempF;
    }

    @JsonProperty("maxtemp_f")
    public void setMaxtempF(Double maxtempF) {
        this.maxtempF = maxtempF;
    }

    @JsonProperty("mintemp_c")
    public Double getMintempC() {
        return mintempC;
    }

    @JsonProperty("mintemp_c")
    public void setMintempC(Double mintempC) {
        this.mintempC = mintempC;
    }

    @JsonProperty("mintemp_f")
    public Double getMintempF() {
        return mintempF;
    }

    @JsonProperty("mintemp_f")
    public void setMintempF(Double mintempF) {
        this.mintempF = mintempF;
    }

    @JsonProperty("avgtemp_c")
    public Double getAvgtempC() {
        return avgtempC;
    }

    @JsonProperty("avgtemp_c")
    public void setAvgtempC(Double avgtempC) {
        this.avgtempC = avgtempC;
    }

    @JsonProperty("avgtemp_f")
    public Double getAvgtempF() {
        return avgtempF;
    }

    @JsonProperty("avgtemp_f")
    public void setAvgtempF(Double avgtempF) {
        this.avgtempF = avgtempF;
    }

    @JsonProperty("maxwind_mph")
    public Double getMaxwindMph() {
        return maxwindMph;
    }

    @JsonProperty("maxwind_mph")
    public void setMaxwindMph(Double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    @JsonProperty("maxwind_kph")
    public Double getMaxwindKph() {
        return maxwindKph;
    }

    @JsonProperty("maxwind_kph")
    public void setMaxwindKph(Double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    @JsonProperty("totalprecip_mm")
    public Double getTotalprecipMm() {
        return totalprecipMm;
    }

    @JsonProperty("totalprecip_mm")
    public void setTotalprecipMm(Double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    @JsonProperty("totalprecip_in")
    public Double getTotalprecipIn() {
        return totalprecipIn;
    }

    @JsonProperty("totalprecip_in")
    public void setTotalprecipIn(Double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    @JsonProperty("totalsnow_cm")
    public Double getTotalsnowCm() {
        return totalsnowCm;
    }

    @JsonProperty("totalsnow_cm")
    public void setTotalsnowCm(Double totalsnowCm) {
        this.totalsnowCm = totalsnowCm;
    }

    @JsonProperty("avgvis_km")
    public Double getAvgvisKm() {
        return avgvisKm;
    }

    @JsonProperty("avgvis_km")
    public void setAvgvisKm(Double avgvisKm) {
        this.avgvisKm = avgvisKm;
    }

    @JsonProperty("avgvis_miles")
    public Double getAvgvisMiles() {
        return avgvisMiles;
    }

    @JsonProperty("avgvis_miles")
    public void setAvgvisMiles(Double avgvisMiles) {
        this.avgvisMiles = avgvisMiles;
    }

    @JsonProperty("avghumidity")
    public Double getAvghumidity() {
        return avghumidity;
    }

    @JsonProperty("avghumidity")
    public void setAvghumidity(Double avghumidity) {
        this.avghumidity = avghumidity;
    }

    @JsonProperty("daily_will_it_rain")
    public Long getDailyWillItRain() {
        return dailyWillItRain;
    }

    @JsonProperty("daily_will_it_rain")
    public void setDailyWillItRain(Long dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public Long getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    @JsonProperty("daily_chance_of_rain")
    public void setDailyChanceOfRain(Long dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    @JsonProperty("daily_will_it_snow")
    public Long getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    @JsonProperty("daily_will_it_snow")
    public void setDailyWillItSnow(Long dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public Long getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    @JsonProperty("daily_chance_of_snow")
    public void setDailyChanceOfSnow(Long dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    @JsonProperty("condition")
    public Condition__1 getCondition() {
        return condition;
    }

    @JsonProperty("condition")
    public void setCondition(Condition__1 condition) {
        this.condition = condition;
    }

    @JsonProperty("uv")
    public Double getUv() {
        return uv;
    }

    @JsonProperty("uv")
    public void setUv(Double uv) {
        this.uv = uv;
    }

}

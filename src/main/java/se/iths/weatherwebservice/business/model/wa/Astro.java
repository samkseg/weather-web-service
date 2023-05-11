
package se.iths.weatherwebservice.business.model.wa;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sunrise",
    "sunset",
    "moonrise",
    "moonset",
    "moon_phase",
    "moon_illumination",
    "is_moon_up",
    "is_sun_up"
})
public class Astro {

    @JsonProperty("sunrise")
    private String sunrise;
    @JsonProperty("sunset")
    private String sunset;
    @JsonProperty("moonrise")
    private String moonrise;
    @JsonProperty("moonset")
    private String moonset;
    @JsonProperty("moon_phase")
    private String moonPhase;
    @JsonProperty("moon_illumination")
    private String moonIllumination;
    @JsonProperty("is_moon_up")
    private Long isMoonUp;
    @JsonProperty("is_sun_up")
    private Long isSunUp;

    @JsonProperty("sunrise")
    public String getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public String getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("moonrise")
    public String getMoonrise() {
        return moonrise;
    }

    @JsonProperty("moonrise")
    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    @JsonProperty("moonset")
    public String getMoonset() {
        return moonset;
    }

    @JsonProperty("moonset")
    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    @JsonProperty("moon_phase")
    public String getMoonPhase() {
        return moonPhase;
    }

    @JsonProperty("moon_phase")
    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    @JsonProperty("moon_illumination")
    public String getMoonIllumination() {
        return moonIllumination;
    }

    @JsonProperty("moon_illumination")
    public void setMoonIllumination(String moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    @JsonProperty("is_moon_up")
    public Long getIsMoonUp() {
        return isMoonUp;
    }

    @JsonProperty("is_moon_up")
    public void setIsMoonUp(Long isMoonUp) {
        this.isMoonUp = isMoonUp;
    }

    @JsonProperty("is_sun_up")
    public Long getIsSunUp() {
        return isSunUp;
    }

    @JsonProperty("is_sun_up")
    public void setIsSunUp(Long isSunUp) {
        this.isSunUp = isSunUp;
    }

}

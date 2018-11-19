
package mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Current {

    @Expose
    private Double cloud;
    @Expose
    @Embedded
    private Condition condition;
    @SerializedName("feelslike_c")
    private Double feelslikeC;
    @SerializedName("feelslike_f")
    private Double feelslikeF;
    @Expose
    private Double humidity;
    @SerializedName("is_day")
    private Double isDay;
    @SerializedName("last_updated")
    private String lastUpdated;
    @SerializedName("last_updated_epoch")
    private Double lastUpdatedEpoch;
    @SerializedName("precip_in")
    private Double precipIn;
    @SerializedName("precip_mm")
    private Double precipMm;
    @SerializedName("pressure_in")
    private Double pressureIn;
    @SerializedName("pressure_mb")
    private Double pressureMb;
    @SerializedName("temp_c")
    private Double tempC;
    @SerializedName("temp_f")
    private Double tempF;
    @Expose
    private Double uv;
    @SerializedName("vis_km")
    private Double visKm;
    @SerializedName("vis_miles")
    private Double visMiles;
    @SerializedName("wind_degree")
    private Double windDegree;
    @SerializedName("wind_dir")
    private String windDir;
    @SerializedName("wind_kph")
    private Double windKph;
    @SerializedName("wind_mph")
    private Double windMph;

    public Double getCloud() {
        return cloud;
    }

    public void setCloud(Double cloud) {
        this.cloud = cloud;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getFeelslikeC() {
        return feelslikeC;
    }

    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    public Double getFeelslikeF() {
        return feelslikeF;
    }

    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getIsDay() {
        return isDay;
    }

    public void setIsDay(Double isDay) {
        this.isDay = isDay;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Double getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    public void setLastUpdatedEpoch(Double lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }

    public Double getPrecipIn() {
        return precipIn;
    }

    public void setPrecipIn(Double precipIn) {
        this.precipIn = precipIn;
    }

    public Double getPrecipMm() {
        return precipMm;
    }

    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    public Double getPressureIn() {
        return pressureIn;
    }

    public void setPressureIn(Double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public Double getPressureMb() {
        return pressureMb;
    }

    public void setPressureMb(Double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public Double getTempC() {
        return tempC;
    }

    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    public Double getTempF() {
        return tempF;
    }

    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    public Double getUv() {
        return uv;
    }

    public void setUv(Double uv) {
        this.uv = uv;
    }
    public Double getVisKm() {
        return visKm;
    }

    public void setVisKm(Double visKm) {
        this.visKm = visKm;
    }

    public Double getVisMiles() {
        return visMiles;
    }

    public void setVisMiles(Double visMiles) {
        this.visMiles = visMiles;
    }

    public Double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Double windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public Double getWindKph() {
        return windKph;
    }

    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    public Double getWindMph() {
        return windMph;
    }

    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

}

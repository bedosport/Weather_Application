
package mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel;

import android.arch.persistence.room.Embedded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Forecastday {

    @Expose
    @Embedded
    private Astro astro;
    @Expose
    private String date;
    @SerializedName("date_epoch")
    private Long dateEpoch;
    @Expose
    @Embedded
    private Day day;

    public Astro getAstro() {
        return astro;
    }

    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getDateEpoch() {
        return dateEpoch;
    }

    public void setDateEpoch(Long dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

}

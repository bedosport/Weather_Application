
package mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.Expose;

import java.util.List;

import mvvm.fared.weatherapplication.Model.DataTypeConverter;

@SuppressWarnings("unused")
public class Forecast {

    @Expose
    @TypeConverters(DataTypeConverter.class)
    private List<Forecastday> forecastday;

    public List<Forecastday> getForecastday() {
        return forecastday;
    }

    public void setForecastday(List<Forecastday> forecastday) {
        this.forecastday = forecastday;
    }

}

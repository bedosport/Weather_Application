
package mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity
public class CurrentForecastWeatherModel {

    @PrimaryKey(autoGenerate = true)
    int id;
    @Expose
    @Embedded
    private Current current;
    @Expose
    @Embedded
    private Forecast forecast;
    @Expose
    @Embedded
    private Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}

package mvvm.fared.weatherapplication.Model.WeatherRoom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;

@Dao
public interface WeatherDAO {
    @Insert
    public void addCity(CurrentForecastWeatherModel city);

    @Delete
    public void deleteCity(CurrentForecastWeatherModel city);

    @Update
    public void updateCity(CurrentForecastWeatherModel city);

    @Query("delete from CurrentForecastWeatherModel")
    public void deleteAllCities();

    @Query("select * from CurrentForecastWeatherModel")
    public LiveData<List<CurrentForecastWeatherModel >> getAllCities();
}

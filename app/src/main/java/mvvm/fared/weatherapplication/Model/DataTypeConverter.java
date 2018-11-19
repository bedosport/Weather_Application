package mvvm.fared.weatherapplication.Model;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.Forecastday;

public class DataTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public static List<Forecastday> stringToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Forecastday>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ListToString(List<Forecastday> someObjects) {
        return gson.toJson(someObjects);
    }
}

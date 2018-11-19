package mvvm.fared.weatherapplication.Model.WeatherRoom;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;

@Database(entities = CurrentForecastWeatherModel.class,version = 1,exportSchema=false)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDAO weatherDAO();
    private static WeatherDatabase weatherDatabase;
    public static synchronized WeatherDatabase getInstance(Context context){
        if(weatherDatabase==null)
            weatherDatabase= Room
                    .databaseBuilder(context.getApplicationContext(),WeatherDatabase.class,"weather-database")
                    .fallbackToDestructiveMigration()
                    .build();
        return weatherDatabase;
    }
}

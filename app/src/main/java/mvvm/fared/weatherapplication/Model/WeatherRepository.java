package mvvm.fared.weatherapplication.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

import java.util.List;

import mvvm.fared.weatherapplication.Model.WeatherRoom.WeatherDAO;
import mvvm.fared.weatherapplication.Model.WeatherRoom.WeatherDatabase;
import mvvm.fared.weatherapplication.Model.WeratherAPI.APIManager;
import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import mvvm.fared.weatherapplication.Model.WeratherAPI.Services;
import retrofit2.Call;

public class WeatherRepository {
    private WeatherDAO weatherDAO;
    APIManager apiManager;
    String city;
    private LiveData<List<CurrentForecastWeatherModel>> weatherList;

    public WeatherRepository(Application application,String city) {
        WeatherDatabase weatherDatabase=WeatherDatabase.getInstance(application);
        weatherDAO=weatherDatabase.weatherDAO();
        weatherList=weatherDAO.getAllCities();
        this.city=city;
    }
    public void insert(CurrentForecastWeatherModel city) {
        new InsertCityAsyncTask(weatherDAO).execute(city);
    }

    public void update(CurrentForecastWeatherModel city) {
        new UpdateCityAsyncTask(weatherDAO).execute(city);
    }

    public void delete(CurrentForecastWeatherModel city) {
        new DeleteCityAsyncTask(weatherDAO).execute(city);
    }

    public void deleteAllCities() {
        new DeleteAllCitiesAsyncTask(weatherDAO).execute();
    }

    public LiveData<List<CurrentForecastWeatherModel>> getAllCities() {
        return weatherList;
    }

    public boolean isNetworkAvailable(Context mContext) {
        Context context = mContext.getApplicationContext();
        ConnectivityManager connectivity = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Services addCityWeather(){
        return APIManager.getAPIS("http://api.apixu.com/v1/");
    }

    private static class InsertCityAsyncTask extends AsyncTask<CurrentForecastWeatherModel, Void, Void> {
        private WeatherDAO weatherDAO;

        private InsertCityAsyncTask(WeatherDAO weatherDAO) {
            this.weatherDAO = weatherDAO;
        }

        @Override
        protected Void doInBackground(CurrentForecastWeatherModel... cities) {
            weatherDAO.addCity(cities[0]);
            return null;
        }
    }

    private static class UpdateCityAsyncTask extends AsyncTask<CurrentForecastWeatherModel, Void, Void> {
        private WeatherDAO weatherDAO;

        private UpdateCityAsyncTask(WeatherDAO weatherDAO) {
            this.weatherDAO = weatherDAO;
        }

        @Override
        protected Void doInBackground(CurrentForecastWeatherModel... cities) {
            weatherDAO.updateCity(cities[0]);
            return null;
        }
    }

    private static class DeleteCityAsyncTask extends AsyncTask<CurrentForecastWeatherModel, Void, Void> {
        private WeatherDAO weatherDAO;

        private DeleteCityAsyncTask(WeatherDAO weatherDAO) {
            this.weatherDAO = weatherDAO;
        }

        @Override
        protected Void doInBackground(CurrentForecastWeatherModel... cities) {
            weatherDAO.deleteCity(cities[0]);
            return null;
        }
    }

    private static class DeleteAllCitiesAsyncTask extends AsyncTask<Void, Void, Void> {
        private WeatherDAO weatherDAO;

        private DeleteAllCitiesAsyncTask(WeatherDAO weatherDAO) {
            this.weatherDAO = weatherDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            weatherDAO.deleteAllCities();
            return null;
        }
    }
}

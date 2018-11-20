package mvvm.fared.weatherapplication.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.List;

import mvvm.fared.weatherapplication.Model.WeatherRepository.WeatherRepository;
import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.Condition;
import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends AndroidViewModel {
    private WeatherRepository repository;

    public WeatherViewModel(@NonNull final Application application) {
        super(application);
        repository = new WeatherRepository(application);
    }

    public void getCitiesWeatherList(final Context context, String city) {
        if (repository.isNetworkAvailable(context)) {
            deleteAllCities();
            repository.addCityWeather()
                    .getCurrentForecastWeather(city, "7795704a35ca4e32a8482126181811")
                    .enqueue(new Callback<CurrentForecastWeatherModel>() {
                        @Override
                        public void onResponse(Call<CurrentForecastWeatherModel> call, Response<CurrentForecastWeatherModel> response) {
                            if (response.isSuccessful()) {
                                insert(response.body());
                            } else {
                                Toast.makeText(context, "The Link Source Error", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CurrentForecastWeatherModel> call, Throwable t) {
                            Toast.makeText(context, "Check Network Connection", Toast.LENGTH_SHORT).show();
                        }
                    });

        } else {
            Toast.makeText(context, "Check Network Connection", Toast.LENGTH_SHORT).show();

        }
    }


    public void insert(CurrentForecastWeatherModel student) {
        repository.insert(student);
    }

    public void update(CurrentForecastWeatherModel student) {
        repository.update(student);
    }

    public void delete(CurrentForecastWeatherModel student) {
        repository.delete(student);
    }

    public void deleteAllCities() {
        repository.deleteAllCities();
    }

    public LiveData<List<CurrentForecastWeatherModel>> getAllCities() {
        return repository.getAllCities();
    }



}

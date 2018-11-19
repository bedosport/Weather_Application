package mvvm.fared.weatherapplication.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import mvvm.fared.weatherapplication.Model.WeatherRepository;
import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherViewModel extends AndroidViewModel {
    private WeatherRepository repository;
    private String city;
    private LiveData<List<CurrentForecastWeatherModel>> citiesList;
    private MutableLiveData<CurrentForecastWeatherModel> myCity;

    public WeatherViewModel(@NonNull final Application application) {
        super(application);
        repository = new WeatherRepository(application, city);
        myCity = new MutableLiveData<>();
        if (repository.isNetworkAvailable(application.getApplicationContext())) {
            deleteAllCities();
            repository.addCityWeather()
                    .getCurrentForecastWeather(city, "7795704a35ca4e32a8482126181811")
                    .enqueue(new Callback<CurrentForecastWeatherModel>() {
                        @Override
                        public void onResponse(Call<CurrentForecastWeatherModel> call, Response<CurrentForecastWeatherModel> response) {
                            if (response.isSuccessful()) {
                                myCity.setValue(response.body());
                                insert(myCity.getValue());
                            } else {
                                //Toast.makeText(application.getApplicationContext(), response.code()+"", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<CurrentForecastWeatherModel> call, Throwable t) {
                            citiesList = getAllCities();
                            Toast.makeText(application.getApplicationContext(), "Check Network Connection", Toast.LENGTH_SHORT).show();
                        }


                    });

        } else {
            citiesList = repository.getAllCities();
            Toast.makeText(application.getApplicationContext(), "Check Network Connection", Toast.LENGTH_SHORT).show();

        }
    }

    public void setCity(String city) {
        this.city = city;
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
        return citiesList;
    }

    public MutableLiveData<CurrentForecastWeatherModel> getMyCity() {
        return myCity;
    }


}

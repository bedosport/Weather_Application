package mvvm.fared.weatherapplication.Model.WeratherAPI;

import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Services {
    @GET("forecast.json")
    Call<CurrentForecastWeatherModel> getCurrentForecastWeather(@Query("q") String city_name, @Query("key") String key);

}

package mvvm.fared.weatherapplication.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import mvvm.fared.weatherapplication.Base.MyBaseActivity;
import mvvm.fared.weatherapplication.Model.CitiesWeatherAdapter;
import mvvm.fared.weatherapplication.Model.WeratherAPI.APIManager;
import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import mvvm.fared.weatherapplication.R;
import mvvm.fared.weatherapplication.ViewModel.WeatherViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrentForecastWeatherActivity extends MyBaseActivity {
    RecyclerView recyclerView;
    CitiesWeatherAdapter adapter;
    LinearLayoutManager layoutManager;
    WeatherViewModel weatherViewModel;
    SwipeRefreshLayout refreshLayout;
    List<CurrentForecastWeatherModel> weatherModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast_weather);
        Objects.requireNonNull(getSupportActionBar()).setTitle("World Weather");
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel.class);
        recyclerView = findViewById(R.id.my_weather_recycler);
        refreshLayout = findViewById(R.id.refresh);
        adapter = new CitiesWeatherAdapter();
        weatherModelList = new ArrayList<>();
        fillTheRecyclerview();
        whenScroll();
    }

    void addCityWeather(String city) {
        weatherViewModel.getCitiesWeatherList(this, city);
        weatherViewModel.getAllCities().observe(this, new Observer<List<CurrentForecastWeatherModel>>() {
            @Override
            public void onChanged(@Nullable List<CurrentForecastWeatherModel> currentForecastWeatherModels) {
                weatherModelList = currentForecastWeatherModels;
                adapter.setMyWeatherForecast(weatherModelList);
            }
        });


    }

    public void whenScroll() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isNetworkAvailable(getApplicationContext()))
                    fillTheRecyclerview();
                else
                    Toast.makeText(activity, "Check the Network", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                }, 3000);

            }
        });
    }

    public void fillTheRecyclerview() {
        if (!isNetworkAvailable(this)) {
            weatherViewModel.getCitiesWeatherList(this, "egypt");
            weatherViewModel.getAllCities().observe(this, new Observer<List<CurrentForecastWeatherModel>>() {
                @Override
                public void onChanged(@Nullable List<CurrentForecastWeatherModel> currentForecastWeatherModels) {
                    weatherModelList = currentForecastWeatherModels;
                    adapter.setMyWeatherForecast(weatherModelList);
                }
            });
        } else {
            weatherViewModel.deleteAllCities();
            addCityWeather("egypt");
            addCityWeather("paris");
            addCityWeather("italy");
            addCityWeather("germany");
            addCityWeather("holanda");

        }

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contact_us, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_contact_us) {
            startActivity(new Intent(this, ContactUsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
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
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}


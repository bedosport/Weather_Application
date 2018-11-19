package mvvm.fared.weatherapplication.View;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import java.util.Objects;

import mvvm.fared.weatherapplication.Base.MyBaseActivity;
import mvvm.fared.weatherapplication.R;

public class SplashActivity extends MyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,CurrentForecastWeatherActivity.class));
                finish();
            }
        },2500);
    }
}

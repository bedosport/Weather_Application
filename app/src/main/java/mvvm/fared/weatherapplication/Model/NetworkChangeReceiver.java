package mvvm.fared.weatherapplication.Model;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import mvvm.fared.weatherapplication.ViewModel.WeatherViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
        String s = intent.getAction();
        if (s.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            WifiManager wifi = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
            if (wifi.isWifiEnabled()){
                Toast.makeText(context, "Conection Back", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(context, "The Network failed to connect", Toast.LENGTH_SHORT).show();
        }
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
}

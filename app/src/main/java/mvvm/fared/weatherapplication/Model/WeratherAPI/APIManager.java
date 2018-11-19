package mvvm.fared.weatherapplication.Model.WeratherAPI;


import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {

    private static Retrofit retrofitInstance;

    private static Retrofit getInstance(String Base_URL) {
        if (retrofitInstance == null) {
            try {
                retrofitInstance = new Retrofit.Builder()
                        .baseUrl(Base_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (NullPointerException e1) {
                e1.printStackTrace();
            }
            ;


        }
        return retrofitInstance;
    }

    public static Services getAPIS(String Base_URL) {
        return getInstance(Base_URL).create(Services.class);
    }

}

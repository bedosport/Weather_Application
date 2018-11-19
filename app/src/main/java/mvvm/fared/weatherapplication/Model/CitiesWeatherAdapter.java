package mvvm.fared.weatherapplication.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import mvvm.fared.weatherapplication.Model.WeratherAPI.CurrentForecastWeatherModel.CurrentForecastWeatherModel;
import mvvm.fared.weatherapplication.R;

public class CitiesWeatherAdapter extends RecyclerView.Adapter<CitiesWeatherAdapter.ViewHolder> {
    List<CurrentForecastWeatherModel> myWeatherForecast;
    List<ViewHolder> holderList;

    public CitiesWeatherAdapter() {
        holderList = new ArrayList<>();
        myWeatherForecast = new ArrayList<>();
    }

    public void setMyWeatherForecast(CurrentForecastWeatherModel myWeatherForecast) {
        this.myWeatherForecast.add(myWeatherForecast);
        notifyDataSetChanged();
    }

    public void setMyWeatherForecastList(List<CurrentForecastWeatherModel> myWeatherForecast) {
        this.myWeatherForecast = myWeatherForecast;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_weather_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holderList.add(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.line.getVisibility() != View.VISIBLE) {
                    for (ViewHolder holder : holderList) {
                        holder.wind.setVisibility(View.GONE);
                        holder.clouds.setVisibility(View.GONE);
                        holder.humidity.setVisibility(View.GONE);
                        holder.minTemp.setVisibility(View.GONE);
                        holder.maxTemp.setVisibility(View.GONE);
                        holder.bigIconWeather.setVisibility(View.GONE);
                        holder.line.setVisibility(View.GONE);
                        holder.date.setVisibility(View.GONE);
                        holder.time.setVisibility(View.GONE);
                        holder.mainWeather.setVisibility(View.GONE);
                        holder.temp.setVisibility(View.GONE);
                        holder.cityName.setVisibility(View.GONE);
                        //
                        holder.smallIconWeather.setVisibility(View.VISIBLE);
                        holder.line1.setVisibility(View.VISIBLE);
                        holder.temp1.setVisibility(View.VISIBLE);
                        holder.cityName1.setVisibility(View.VISIBLE);

                    }
                    holder.line.setVisibility(View.VISIBLE);
                    holder.cityName.setVisibility(View.VISIBLE);
                    holder.wind.setVisibility(View.VISIBLE);
                    holder.clouds.setVisibility(View.VISIBLE);
                    holder.humidity.setVisibility(View.VISIBLE);
                    holder.minTemp.setVisibility(View.VISIBLE);
                    holder.maxTemp.setVisibility(View.VISIBLE);
                    holder.bigIconWeather.setVisibility(View.VISIBLE);
                    holder.time.setVisibility(View.VISIBLE);
                    holder.date.setVisibility(View.VISIBLE);
                    holder.mainWeather.setVisibility(View.VISIBLE);
                    holder.temp.setVisibility(View.VISIBLE);
                    //
                    holder.smallIconWeather.setVisibility(View.GONE);
                    holder.line1.setVisibility(View.GONE);
                    holder.temp1.setVisibility(View.GONE);
                    holder.cityName1.setVisibility(View.GONE);
                } else {
                    for (ViewHolder holder : holderList) {
                        holder.wind.setVisibility(View.GONE);
                        holder.clouds.setVisibility(View.GONE);
                        holder.humidity.setVisibility(View.GONE);
                        holder.minTemp.setVisibility(View.GONE);
                        holder.maxTemp.setVisibility(View.GONE);
                        holder.bigIconWeather.setVisibility(View.GONE);
                        holder.line.setVisibility(View.GONE);
                        holder.date.setVisibility(View.GONE);
                        holder.time.setVisibility(View.GONE);
                        holder.mainWeather.setVisibility(View.GONE);
                        holder.temp.setVisibility(View.GONE);
                        holder.cityName.setVisibility(View.GONE);
                        //
                        holder.smallIconWeather.setVisibility(View.VISIBLE);
                        holder.line1.setVisibility(View.VISIBLE);
                        holder.temp1.setVisibility(View.VISIBLE);
                        holder.cityName1.setVisibility(View.VISIBLE);

                    }
                }


            }
        });
        holder.cityName.setText(myWeatherForecast.get(position).getLocation().getName());
        holder.cityName1.setText(myWeatherForecast.get(position).getLocation().getName());
        holder.temp1.setText(myWeatherForecast.get(position).getCurrent().getTempC().toString() + "C°");
        holder.temp.setText(myWeatherForecast.get(position).getCurrent().getTempC().toString() + "C°");
        holder.maxTemp.setText("Max: " + myWeatherForecast.get(position).getForecast().getForecastday().get(0).getDay().getMaxtempC().toString() + "°");
        holder.minTemp.setText("Min: " + myWeatherForecast.get(position).getForecast().getForecastday().get(0).getDay().getMintempC().toString() + "°");
        Picasso.get().load("https:" + myWeatherForecast.get(position).getCurrent().getCondition().getIcon()).into(holder.smallIconWeather);
        Picasso.get().load("https:" + myWeatherForecast.get(position).getForecast().getForecastday()
                .get(0).getDay().getCondition().getIcon()).into(holder.bigIconWeather);
        holder.mainWeather.setText(myWeatherForecast.get(position).getForecast().getForecastday().get(0).getDay().getCondition().getText());
        holder.humidity.setText("humidity: " + myWeatherForecast.get(position).getForecast().getForecastday().get(0).getDay().getAvghumidity().toString());
        holder.clouds.setText("cloud: " + myWeatherForecast.get(position).getCurrent().getCloud().toString());
        holder.wind.setText("wind: " + myWeatherForecast.get(position).getForecast().getForecastday().get(0).getDay().getMaxwindMph() + "mph");
        String date_time = myWeatherForecast.get(position).getLocation().getLocaltime();
        String date = "", time = "";
        int indx = 0;
        while (indx < date_time.length()) {
            if (date_time.charAt(indx) == ' ') {
                indx++;
                break;
            }
            date += date_time.charAt(indx);
            indx++;
        }
        while (indx < date_time.length()) {
            time += date_time.charAt(indx);
            indx++;
        }
        holder.time.setText("time: " + time);
        holder.date.setText("date: " + date);

    }

    @Override
    public int getItemCount() {
        if (myWeatherForecast == null)
            return 0;
        return myWeatherForecast.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bigIconWeather;
        TextView cityName;
        TextView temp;
        TextView minTemp;
        TextView maxTemp;
        TextView mainWeather;
        TextView humidity;
        TextView wind;
        TextView clouds;
        TextView date;
        TextView time;
        View line;
        CardView cardView;
        //
        ImageView smallIconWeather;
        TextView temp1;
        TextView cityName1;
        View line1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bigIconWeather = itemView.findViewById(R.id.image_weather);
            cityName = itemView.findViewById(R.id.city_name);
            temp = itemView.findViewById(R.id.weather_temp);
            minTemp = itemView.findViewById(R.id.weather_temp_min);
            maxTemp = itemView.findViewById(R.id.weather_temp_max);
            mainWeather = itemView.findViewById(R.id.main_weather);
            humidity = itemView.findViewById(R.id.humidity);
            wind = itemView.findViewById(R.id.wind);
            clouds = itemView.findViewById(R.id.cloud);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            line = itemView.findViewById(R.id.line);
            //
            smallIconWeather = itemView.findViewById(R.id.small_image_weather);
            temp1 = itemView.findViewById(R.id.weather_temp1);
            cityName1 = itemView.findViewById(R.id.city_name1);
            line1 = itemView.findViewById(R.id.line1);
            //
            cardView = itemView.findViewById(R.id.city_weather_card);
        }
    }
}

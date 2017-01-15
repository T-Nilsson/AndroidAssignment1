package com.example.therese.assignment1.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.therese.assignment1.R;

import java.util.List;

/**
 * Created by nikla on w_14-Jan-17.
 */

public class WeatherAdapter extends ArrayAdapter<WeatherForecast> {
    LayoutInflater inflater;
    public WeatherAdapter(Context context, int resource, int textViewResourceId, List<WeatherForecast> objects) {
        super(context, resource, textViewResourceId, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {
        View row;
        if(rowView == null) {
            row = inflater.inflate(R.layout.row_weather, parent, false);
        }
        else {
            row = rowView;
        }

        WeatherForecast item = getItem(position);
        TextView txtDate = (TextView)row.findViewById(R.id.txtDate);
        TextView txtTemp = (TextView)row.findViewById(R.id.txtTemperature);

        TextView txtWeather = (TextView)row.findViewById(R.id.txtWeather);
        ImageView img = (ImageView)row.findViewById(R.id.img);


        txtDate.setText(item.getStartHHMM()+ "    "+ item.getStartYYMMDD());
        txtWeather.setText(item.getWeatherName());
        txtTemp.setText( item.getTemperature() + " degrees");
        int code = getImageIdByWeatherCode(item);
        img.setImageResource(code);

        return row;
    }

    private int getImageIdByWeatherCode(WeatherForecast item) {
        switch(item.getWeatherCode()) {
            default:
            case 1:
                return R.mipmap.w_1;
            case 2:
                return R.mipmap.w_2;
            case 3:
                return R.mipmap.w_3;
            case 4:
                return R.mipmap.w_4;
            case 5:
                return R.mipmap.w_5;
            case 6:
                return R.mipmap.w_6;
            case 7:
                return R.mipmap.w_7;
            case 8:
                return R.mipmap.w_8;
            case 9:
                return R.mipmap.w_9;
            case 10:
                return R.mipmap.w_10;
            case 11:
                return R.mipmap.w_11;
            case 12:
                return R.mipmap.w_12;
            case 13:
                return R.mipmap.w_13;
            case 14:
                return R.mipmap.w_14;
            case 15:
                return R.mipmap.w_15;
        }
    }
}

package com.example.therese.assignment1.weather;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.example.therese.assignment1.R;

/**
 * Created by nikla on w_14-Jan-17.
 */

public class VaxjoWeather extends ListActivity{
    public static String TAG = "dv606.weather";
    private ListAdapter adapter;
    private InputStream input;
    private WeatherReport report = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                Log.e("Error"+Thread.currentThread().getStackTrace()[2],paramThrowable.getLocalizedMessage());
            }
        });
        // Initialize the layout
        setContentView(R.layout.activity_weather);

        try {
            URL url = new URL("http://www.yr.no/sted/Sverige/Kronoberg/V%E4xj%F6/forecast.xml");
            AsyncTask task = new WeatherRetriever().execute(url);
        } catch (IOException ioe ) {
            ioe.printStackTrace();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.weather_menu, menu);
        return true;
    }

    private void printReportToLog() {
        if (this.report != null) {
            /*Print some meta data to the UI for the testing purposes*/
        	/* Print location meta data */
            Log.i(TAG, report.toString());

        	/* Print forecasts */
            int count = 0;
            for (WeatherForecast forecast : report) {
                count++;
                Log.i(TAG, "Forecast #" + count);
                Log.i(TAG, forecast.toString());
            }
        }
        else {
            Log.e(TAG, "Weather report has not been loaded.");
        }
    }

    public void updateWeatherList(WeatherReport report) {
        adapter = new WeatherAdapter(this, R.layout.row_weather, R.id.txtDate, report.getForecasts());
        setListAdapter(adapter);
    }

    private class WeatherRetriever extends AsyncTask<URL, Void, WeatherReport> {
        protected WeatherReport doInBackground(URL... urls) {
            try {
                return WeatherHandler.getWeatherReport(urls[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        protected void onProgressUpdate(Void... progress) {

        }

        protected void onPostExecute(WeatherReport result) {
            Toast.makeText(getApplicationContext(), "WeatherRetriever task finished", Toast.LENGTH_LONG).show();

            report = result;
            updateWeatherList(result);
            printReportToLog();
        }
    }
}
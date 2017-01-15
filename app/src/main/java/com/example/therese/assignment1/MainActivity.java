package com.example.therese.assignment1;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.therese.assignment1.beerkit.BeerPager;
import com.example.therese.assignment1.weather.VaxjoWeather;

import java.util.ArrayList;

import static com.example.therese.assignment1.R.styleable.View;

public class MainActivity extends ListActivity {
    ArrayList<String> allApps = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        allApps.add("1 - Random number");
        allApps.add("2 - BMI");
        allApps.add("3 - Country List");
        allApps.add("4 - Weather");
        allApps.add("5 - Beer");
        ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, allApps );
        setListAdapter(myAdapter);

        ListView lv = getListView();
        lv.setOnItemClickListener(new ItemClick());
    }

    private class ItemClick implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            Intent intent = new Intent(MainActivity.this, RandomActivity.class);
            MainActivity.this.startActivity(intent);
        }
            else if(position == 1){
            Intent intent = new Intent(MainActivity.this, BMIActivity.class);
            MainActivity.this.startActivity(intent);
        }
        else if(position == 2){
            Intent intent = new Intent(MainActivity.this, MyCountries.class);
            MainActivity.this.startActivity(intent);
        }
        else if(position == 3){
            Intent intent = new Intent(MainActivity.this, VaxjoWeather.class);
            MainActivity.this.startActivity(intent);
        }
        else if(position == 4){
            Intent intent = new Intent(MainActivity.this, BeerPager.class);
            MainActivity.this.startActivity(intent);
        }
        }
    }
}

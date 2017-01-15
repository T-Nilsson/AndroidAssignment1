package com.example.therese.assignment1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.content.Intent;
import java.util.ArrayList;



import java.util.Random;

public class MyCountries extends AppCompatActivity  {

   //Intent intent = new Intent(this_activity,AddCountry.class);
    //this_activity.startActivityForResult(intent);

   // Intent intent = new Intent(this_activity,AddCountry.class);
    //this_activity.startActivityForResult(intent,0);

    ArrayList countryList = new ArrayList<String>();
    String countryInput;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_countries);

    }


    @Override // Catch result
    protected void onActivityResult(int requestCode,int resultCode, Intent result) {
        super.onActivityResult(requestCode, resultCode, result);
        if (resultCode == RESULT_OK) {
            String x = result.getStringExtra("result");
            countryList.add(x);

            ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
            ListView myListView = (ListView) findViewById(R.id.myListView);
            myListView.setAdapter(myAdapter);


        }
    }
            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu res/menu/action_menu.xml (See below)
        getMenuInflater().inflate(R.menu.action_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(MyCountries.this, AddCountry.class);
        MyCountries.this.startActivityForResult(intent, 0);
        return true;
    }
}
package dv606.tn222ei.assignment1.beerkit;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import dv606.tn222ei.assignment1.R;

import java.util.ArrayList;

public class BeerPager extends AppCompatActivity {
    ArrayList<BeerFragment> beers = new ArrayList<BeerFragment>();
    PagerAdapter pagerAdapter;
    TextView beerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_pager);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new BeerAdapter(getFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        beerNumber.setText("Beer " + (position+1) + " of " + pagerAdapter.getCount());
                    }
                }
        );
        beerNumber= (TextView) findViewById(R.id.txtBeerTitle);
        beerNumber.setText("Beer " + (pager.getCurrentItem()+1) + " of " + pagerAdapter.getCount());

    }

}

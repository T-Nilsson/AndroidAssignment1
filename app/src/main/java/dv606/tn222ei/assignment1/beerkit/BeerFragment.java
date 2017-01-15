package dv606.tn222ei.assignment1.beerkit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import dv606.tn222ei.assignment1.R;

/**
 * Created by nikla on 15-Jan-17.
 */

public class BeerFragment extends Fragment {
    final static String INFORMATION_TEXT= "information_text";
    final static String IMAGE_ID = "image_id";
    private ViewGroup rootView;



   public static BeerFragment create(String information, int imageID){
        BeerFragment beer = new BeerFragment();
        Bundle args = new Bundle();
        args.putInt(IMAGE_ID, imageID);
        args.putString(INFORMATION_TEXT, information);
        beer.setArguments(args);
        return beer;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout containing a header and body text.
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_beer, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the header and body text.

        int imageId;
        String txtInformation;
        Bundle args = getArguments();
        if (args != null) {
            txtInformation = args.getString(INFORMATION_TEXT);
            imageId = args.getInt(IMAGE_ID);
        }
        else {
            txtInformation = "Default Header";
            imageId = R.mipmap.ic_launcher;
        }

        // Set the header and body text.
        ((TextView) rootView.findViewById(R.id.txtInfo)).setText(txtInformation);
        ((ImageView) rootView.findViewById(R.id.img)).setImageResource(imageId);
    }
}

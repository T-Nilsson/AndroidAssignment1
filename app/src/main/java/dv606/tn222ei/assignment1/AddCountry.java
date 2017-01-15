package dv606.tn222ei.assignment1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AddCountry extends AppCompatActivity  {
    EditText year;
    EditText countryName;
    TextView a;
    String oneCountry;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);
        Button  buttonAddCountry = (Button)findViewById(R.id. button_addCountry);


        buttonAddCountry.setOnClickListener(new View.OnClickListener() {

            @Override
    public void onClick(View v) {
                year = (EditText) findViewById(R.id.text_enterYear);
                countryName = (EditText) findViewById(R.id.text_enterCountry);
                if(countryName.getText().toString().trim().length() == 0  || year.getText().toString().trim().length() == 0 ){
                    Toast.makeText(v.getContext(), "Fill in fields", Toast.LENGTH_LONG).show();
                    return;}

                oneCountry = (year.getText().toString() + " " + countryName.getText().toString());


                Intent result = new Intent(AddCountry.this, MyCountries.class);
                result.putExtra("result", oneCountry); // Add key/value pair
                setResult(RESULT_OK, result);
                finish();

            } });



    }}
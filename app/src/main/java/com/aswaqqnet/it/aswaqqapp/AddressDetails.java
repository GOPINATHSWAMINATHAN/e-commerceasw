package com.aswaqqnet.it.aswaqqapp;

import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressDetails extends AppCompatActivity {

    AutoCompleteTextView actv;
    TextInputLayout til,til1,til2,til3,til4;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actv=(AutoCompleteTextView)findViewById(R.id.city_array);
        String cities[] = getResources().getStringArray(R.array.cities);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, cities);
        actv.setAdapter(adapter);
        actv.setThreshold(2);
//        til=(TextInputLayout)findViewById(R.id.first_auto);
//        til1=(TextInputLayout)findViewById(R.id.last_auto);
//        til2=(TextInputLayout)findViewById(R.id.address_auto);
//        til3=(TextInputLayout)findViewById(R.id.city_auto);
//        til4=(TextInputLayout)findViewById(R.id.phone_auto);
    ed1=(EditText)findViewById(R.id.firstname);
        ed2=(EditText)findViewById(R.id.lastname);
        ed3=(EditText)findViewById(R.id.address);
        ed4=(EditText)findViewById(R.id.phoneno);
        ed5=(EditText)findViewById(R.id.city_array);
        ed6=(EditText)findViewById(R.id.email_auto);
        Button buy=(Button)findViewById(R.id.buy_delivery);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().isEmpty())
                {
                    ed1.setError("Please Enter your First Name");
                }
                if(ed2.getText().toString().isEmpty())
                {
                    ed2.setError("Please Enter your Last Name");
                }
                if(ed3.getText().toString().isEmpty())
                {
                    ed3.setError("Please Enter your Address");
                }
                if(ed4.getText().toString().isEmpty())
                {
                    ed4.setError("Please Enter your Phone No.");
                }
                if(ed5.getText().toString().isEmpty())
                {
                    ed5.setError("Please Enter the city");
                }
                if(ed6.getText().toString().isEmpty()&&!validateEmail(ed6.getText().toString()))
                {
                    ed6.setError("Please Enter Valid Email address");
                }
                if(!ed1.getText().toString().isEmpty()&&!ed2.getText().toString().isEmpty()&&!ed3.getText().toString().isEmpty()&&!ed4.getText().toString().isEmpty()&&!ed5.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Successfully Purchased!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}

package com.aswaqqnet.it.aswaqqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hariofspades.incdeclibrary.IncDecCircular;


public class Cart extends AppCompatActivity {
Button buyCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Button b=(Button)findViewById(R.id.buy_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddressDetails.class));
            }
        });
        IncDecCircular incdec=(IncDecCircular)findViewById(R.id.incdec);
        incdec.setOnClickListener(new IncDecCircular.OnClickListener() {
            @Override
            public void onClick(View view) {
                //For Array
                Toast.makeText(getApplicationContext(),
                        String.valueOf(incdec.getCurrentIndex()), Toast.LENGTH_SHORT).show();
                //For int and float
                Toast.makeText(getApplicationContext(),
                        incdec.getValue(), Toast.LENGTH_SHORT).show();
            }
        });
        incdec.setOnValueChangeListener(new IncDecCircular.OnValueChangeListener() {
            @Override
            public void onValueChange(IncDecCircular view, float oldValue, float newValue) {
                Toast.makeText(getApplicationContext(), String.valueOf(oldValue)+"/"+
                        String.valueOf(newValue), Toast.LENGTH_SHORT).show();
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
}

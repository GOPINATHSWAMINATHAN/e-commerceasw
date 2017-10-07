package com.aswaqqnet.it.aswaqqapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
                Toast.makeText(getApplicationContext(),"increment",Toast.LENGTH_LONG).show();
            }
        });
    }
}

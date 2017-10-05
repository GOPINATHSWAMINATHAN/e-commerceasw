package com.aswaqqnet.it.aswaqqapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hariofspades.incdeclibrary.IncDecCircular;


public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        IncDecCircular incdec=(IncDecCircular)findViewById(R.id.incdec);
        incdec.setOnClickListener(new IncDecCircular.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"increment",Toast.LENGTH_LONG).show();
            }
        });
    }
}

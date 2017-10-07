package com.aswaqqnet.it.aswaqqapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by IT on 10/1/2017.
 */

public class ProductDisplay extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_display);
        b1=(Button)findViewById(R.id.buy_now);
        b2=(Button)findViewById(R.id.add_to_cart);
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "font.otf");
        b1.setTypeface(tf);
        b2.setTypeface(tf);
       b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Cart.class);
                startActivity(i);

            }
        });
       // blink();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Cart.class);
                startActivity(i);
            }
        });
    }
    private void blink(){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int timeToBlink = 500;    //in milissegunds
                try{Thread.sleep(timeToBlink);}catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView txt = (TextView) findViewById(R.id.buy_now);
                        TextView txt2=(TextView)findViewById(R.id.add_to_cart);
                        if(txt.getVisibility() == View.VISIBLE||txt2.getVisibility()==View.VISIBLE){
                            txt.setVisibility(View.INVISIBLE);
                            txt2.setVisibility(View.INVISIBLE);
                        }
                        else
                        {
                            txt.setVisibility(View.VISIBLE);
                            txt2.setVisibility(View.VISIBLE);
                        }blink();
                    }
                });
            }
        }).start();
    }
}

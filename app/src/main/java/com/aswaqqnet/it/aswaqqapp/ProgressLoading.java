package com.aswaqqnet.it.aswaqqapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by IT on 10/4/2017.
 */

public class ProgressLoading extends Activity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_bar);
        ProgressBar p=findViewById(R.id.progress_bar);
        p.setIndeterminate(true);

    }
}

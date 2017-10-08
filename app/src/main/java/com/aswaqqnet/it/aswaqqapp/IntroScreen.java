package com.aswaqqnet.it.aswaqqapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class IntroScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        String app_name = getResources().getString(R.string.app_name);
        String copyright = getResources().getString(R.string.copyright);
        String welcome = getResources().getString(R.string.welcome);
        String intro=getResources().getString(R.string.intro);
        EasySplashScreen config = new EasySplashScreen(this)
                .withFullScreen()
                .withTargetActivity(Drawer.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(android.R.color.holo_red_light)
                .withHeaderText(app_name)
                .withFooterText(copyright)
                .withBeforeLogoText(welcome)
                .withLogo(R.drawable.logo_one)
                .withAfterLogoText(intro);

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "font.otf");
        config.getAfterLogoTextView().setTypeface(pacificoFont);
        config.getHeaderTextView().setTextColor(Color.WHITE);
        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
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

        EasySplashScreen config = new EasySplashScreen(this)
                .withFullScreen()
                .withTargetActivity(Drawer.class)
                .withSplashTimeOut(4000)
                .withBackgroundResource(android.R.color.holo_red_light)
                .withHeaderText("AswaqqNet")
                .withFooterText("Copyright 2017")
                .withBeforeLogoText("Welcome to AswaqqNet")
                .withLogo(R.drawable.logo_one)
                .withAfterLogoText("AswaqqNet provides easy shopping throughout KSA");

        Typeface pacificoFont = Typeface.createFromAsset(getAssets(), "font.otf");
        config.getAfterLogoTextView().setTypeface(pacificoFont);

        config.getHeaderTextView().setTextColor(Color.WHITE);

        View easySplashScreenView = config.create();
        setContentView(easySplashScreenView);
    }
}
package com.aswaqqnet.it.aswaqqapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

import gr.net.maroulis.library.EasySplashScreen;

public class IntroScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String path="http://www.ted.com/talks/download/video/8584/talk/761";
//        String path1="https://firebasestorage.googleapis.com/v0/b/zakerr-cb5de.appspot.com/o/%D8%A7%D8%B3%D9%88%D8%A7%D9%82%20%D9%86%D8%AA.mp4?alt=media&token=ab525fd5-0b74-41d6-b126-c1b09c4fdfdf";
//
//        Uri uri=Uri.parse(path1);
//
//        VideoView video=(VideoView)findViewById(R.id.video_view);
//        video.setVideoURI(uri);
//        video.start();
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
        setContentView(easySplashScreenView );
    }
}
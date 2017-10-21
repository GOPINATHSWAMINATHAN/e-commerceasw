package com.aswaqqnet.it.aswaqqapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * Created by IT on 10/21/2017.
 */

public class WomenCloth extends Fragment {

    LocalBroadcastManager manager;
    ArrayList al;
    ArrayList al2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_women_cloth, container, false);
       new WomenClothRetrieve().execute();
       // Toast.makeText(getActivity(), "Values are " + new WomenClothRetrieve().methodOne(), Toast.LENGTH_LONG).show();
        EventBus.getDefault().register(this);
        return v;
    }
    @Subscribe
    public void onEvent(WomenPojo event)
    {
        al=event.product_code;
        al2=event.product_image;
        //adapter = new (al,al2);
        //recyclerView.setAdapter(adapter);
        Log.d("EVENT CLASS VALUES",""+al+""+al2);
        Toast.makeText(getActivity(),"new values are"+al+""+al2,Toast.LENGTH_LONG).show();
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        new WomenClothRetrieve().execute();
    }
    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

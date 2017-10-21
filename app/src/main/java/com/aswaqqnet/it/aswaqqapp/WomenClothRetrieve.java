package com.aswaqqnet.it.aswaqqapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by IT on 10/21/2017.
 */

public class WomenClothRetrieve extends AsyncTask<String, Void, String> {
   // Context context;
//LocalBroadcastManager manager=LocalBroadcastManager.getInstance(context);
   String url="http://aswaqqnet.com/web/en/androidview/prod.php?edit_id=598";
    String image_url="https://www.aswaqqnet.com/web/admin/malls/goods_images/";
    String array = "aaData";
    ArrayList product_code=new ArrayList();
    ArrayList product_image=new ArrayList();
    ArrayList product_name=new ArrayList();
    ArrayList price=new ArrayList();
    @Override
    protected String doInBackground(String... strings) {
        RequestBody body;
        Response response;
        String jsonData = null;

        OkHttpClient client = new OkHttpClient();
        body = new FormBody.Builder().build();
        Request request = new Request.Builder().url(url).post(body).build();
        Call call = client.newCall(request);
        try {
            response = call.execute();
            if (response.isSuccessful()) {
                jsonData = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return jsonData;
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected void onPostExecute(String jsonData) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray(array);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonobject = jsonArray.getJSONObject(i);
                product_code.add(jsonobject.optString("product_code"));
                String name=jsonobject.optString("product_img_name");
                product_image.add(image_url.concat(name));
                product_name.add(jsonobject.getString("product_name"));
                price.add(jsonobject.getString("price"));

                EventBus.getDefault().post(new WomenPojo(product_code,product_image,product_name,price));
            }

            Log.w("Gopi PRODUCT VALUES ARE",product_code+""+product_image+""+product_name+""+price );

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public ArrayList methodOne()
    {
        return product_image;
    }
    }



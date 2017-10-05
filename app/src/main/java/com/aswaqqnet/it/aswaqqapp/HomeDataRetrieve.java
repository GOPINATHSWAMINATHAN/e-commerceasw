package com.aswaqqnet.it.aswaqqapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by IT on 10/5/2017.
 */

public class HomeDataRetrieve extends AsyncTask<String, Void, String> {

    String department;

    String url = "https://www.aswaqqnet.com/web/en/andcheck.php";
    String product_code = "product_code";
    String price = "price";
    String product_name = "product_name";
    String array = "aaData";

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
        JSONObject jsonObject=null;
        try {
            jsonObject=new JSONObject(jsonData);
            JSONArray jsonArray=jsonObject.getJSONArray(array);
            if(jsonArray!=null)
            {
                for (int i=0;i<jsonArray.length();i++)
                {
                    JSONObject object=jsonArray.getJSONObject(i);
                    JSONArray arrJson=object.getJSONArray(product_name);
                    String[] arr=new String[arrJson.length()];
                    for(int k=0;k<arrJson.length();k++)
                    {
                        String prices=object.getString(price);
                        arr[k]=arrJson.getString(k);
                        Log.e("arrayValues",arr[k]);
                        Log.e("priceValues",prices);
                    }

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

package com.aswaqqnet.it.aswaqqapp;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
                for(int i=0;i<jsonArray.length();i++)
                {
                    JSONObject object=jsonArray.getJSONObject(i);
                    String prices=object.getString(price);
                    String products=object.getString(product_name);
                    Log.e("product_name",products);
                    Log.e("prices",prices);
                }
//                for (int i=0;i<jsonArray.length();i++)
//                {
//                    JSONObject object=jsonArray.getJSONObject(i);
//                    JSONArray arrJson=object.getJSONArray(array);
//                    Log.e("Array Values are ",""+    arrJson);
//                   // String[] arr=new String[arrJson.length()];
//                    for(int k=0;k<arrJson.length();k++)
//                    {
//                        JSONObject rec = arrJson.getJSONObject(i);
//                        String prices=rec.getString(price);
//                        String products_name=rec.getString(product_name);
//                        Log.e("productName",products_name);
//                        Log.e("priceValues",prices);
//                    }
//                    //Toast.makeText(,"Your Message", Toast.LENGTH_LONG).show();
//                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

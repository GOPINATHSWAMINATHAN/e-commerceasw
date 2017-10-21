package com.aswaqqnet.it.aswaqqapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
//import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

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

    Context context;
    String department;
    ArrayList al = new ArrayList();
    ArrayList<String> al1 = new ArrayList();
    ArrayList<String> oldPrice = new ArrayList();
    ArrayList<String> newPrice = new ArrayList();
    String url = "https://www.aswaqqnet.com/web/en/androidview/andview1.php";
    //    String product_code = "product_code";
//    String price = "price";
//    String product_name = "product_name";
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
        JSONObject jsonObject = null;
        int k = 1;

        for (int j = 0; j < 33; j++) {
            try {
                jsonObject = new JSONObject(jsonData);
                JSONArray jsonArray = jsonObject.getJSONArray(array + k);
                k++;
                if (jsonArray != null) {

                    for (int i = 0; i < jsonArray.length(); i++) {
//                        Log.e("HOME SCREEN DATA", jsonArray.getString(i));
//                        Log.e("SHOES",jsonArray.getString(0));
                        al1.add(jsonArray.getString(0));
                        oldPrice.add(jsonArray.getString(2));
                        newPrice.add(jsonArray.getString(3));
                      al.add(jsonArray.getString(7));
                        Log.e("Image Value", ""+al);
                      // Log.e("SHOES",jsonArray.getString(0));

                    }

//                for(int i=0;i<jsonArray.length();i++)
//                {
//                    JSONObject object=jsonArray.getJSONObject(i);
//                    String prices=object.getString(price);
//                    String products=object.getString(product_name);
//                    Log.e("product_name",products);
//                    Log.e("prices",prices);
//                }
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
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            }
//            catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
//    public static Drawable drawableFromUrl(String url) throws IOException {
//        Bitmap x;
//
//        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//        connection.connect();
//        InputStream input = connection.getInputStream();
//
//        x = BitmapFactory.decodeStream(input);
//        return new BitmapDrawable(x);
//    }
}

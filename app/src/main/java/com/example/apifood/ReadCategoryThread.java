package com.example.apifood;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONObject;

public class ReadCategoryThread extends AsyncTask<String,Void,String> {
    private Context context;

    public ReadCategoryThread(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {


            OkHttpClient okHttpClient = new OkHttpClient();
            MediaType jsonType = MediaType.parse("application/json; charset=utf-8");
            JSONObject jsonObject =new JSONObject();
            jsonObject.put("ptPsgNamw", strings[0]);

            String jsonString = "{\n" +
                    "\t \"ptPsgName\":\"\"\n" +
                    "}";

            RequestBody requestBody = RequestBody.create(jsonType, jsonString);

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[1]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            Log.d("5MayV1","e ==> " + e.toString());
            return null;
        }



    }
} //Main Class

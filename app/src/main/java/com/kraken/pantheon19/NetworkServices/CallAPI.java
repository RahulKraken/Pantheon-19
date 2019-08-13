package com.kraken.pantheon19.NetworkServices;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.MyApplication;

import java.util.List;

public class CallAPI {

    private static final String TAG = "CallAPI";

    public void getEvents() {
        StringRequest request = new StringRequest(Request.Method.GET, "http://127.0.0.1:8000/allevents", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: " + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error.toString());
            }
        });

        MyApplication.getVolleyRequestQueue().add(request);
    }
}

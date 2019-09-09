package com.kraken.pantheon19.NetworkServices;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.MyApplication;
import com.kraken.pantheon19.Utils.Serializer;

import java.util.List;

public class ApiService {
    private static final String TAG = "ApiService";

    public void getFormalEvents(String url) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: 200 OK\n" + response);
                // serialize raw response
                List<Event> formalEvents = Serializer.serializeEvents(response);
                Log.d(TAG, "onResponse: " + formalEvents.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error);
            }
        });

        MyApplication.getVolleyRequestQueue().add(request);
    }

    public void getInormalEvents(String url) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: 200 OK\n" + response);
                // serialize raw response
                List<Event> informalEvents = Serializer.serializeEvents(response);
                Log.d(TAG, "onResponse: " + informalEvents.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error);
            }
        });

        MyApplication.getVolleyRequestQueue().add(request);
    }

    public void getFlagshipEvents(String url) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: 200 OK\n" + response);
                // serialize raw response
                List<Event> flagshipEvents = Serializer.serializeEvents(response);
                Log.d(TAG, "onResponse: " + flagshipEvents.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onErrorResponse: " + error);
            }
        });

        MyApplication.getVolleyRequestQueue().add(request);
    }
}

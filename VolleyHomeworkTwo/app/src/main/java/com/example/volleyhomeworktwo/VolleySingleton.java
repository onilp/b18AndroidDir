package com.example.volleyhomeworktwo;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static final String TAG = VolleySingleton.class.getSimpleName();
    private static VolleySingleton volleyInstance;
    private final RequestQueue requestQueue;

    private VolleySingleton(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    static synchronized VolleySingleton getInstance(Context context){
        if(volleyInstance == null){
            volleyInstance = new VolleySingleton(context);
        }
        return volleyInstance;
    }

    private RequestQueue getRequestQueue(){
        return requestQueue;
    }

    <T> void addToRequestQueue(Request<T> request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }
}

package com.example.myactivity;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MyIntentService() {
        super("My thread");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(1000);
                //this wont work because this is a worker thread
                Toast.makeText(this, "Texting", Toast.LENGTH_SHORT).show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "IntentService onCreate", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        String someValue = intent.getExtras().getString("passToService");
        Toast.makeText(this, someValue, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "IntentService onDestroy", Toast.LENGTH_SHORT).show();
    }
}

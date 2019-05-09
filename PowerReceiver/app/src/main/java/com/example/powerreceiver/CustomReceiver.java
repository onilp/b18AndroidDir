package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        String toastMessage = null;

        assert intentAction != null;
        switch (intentAction){
            case Intent.ACTION_POWER_CONNECTED:
                toastMessage = "Power connected!";
                break;

            case Intent.ACTION_POWER_DISCONNECTED:
                toastMessage = "Power disconnected!";
                break;
        }

        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
}

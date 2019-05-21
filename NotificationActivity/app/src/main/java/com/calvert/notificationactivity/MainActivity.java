package com.calvert.notificationactivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clickButton = findViewById(R.id.click_button);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel("YOUR_CHANNEL_ID", "YOUR_CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                    channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DISCRIPTION");
                    mNotificationManager.createNotificationChannel(channel);
                }
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("key", 0);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                intent2.putExtra("key", 0);
                PendingIntent pi2 = PendingIntent.getActivity(MainActivity.this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "YOUR_CHANNEL_ID")
                        .setSmallIcon(R.drawable.ic_assistant_photo_black_24dp) // notification icon
                        .setContentTitle("Title") // title for notification
                        .setContentText("Message")// message for notification
                        .setAutoCancel(true) // clear notification after click
                        .addAction(R.drawable.ic_assistant_photo_black_24dp, "Please", pi)
                        .addAction(R.drawable.ic_assistant_photo_black_24dp, "OMG", pi2);

                mBuilder.setContentIntent(pi);
                mNotificationManager.notify(0, mBuilder.build());
            }
        });
    }
}

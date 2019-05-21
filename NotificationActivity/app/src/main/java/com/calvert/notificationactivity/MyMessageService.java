package com.calvert.notificationactivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessageService extends FirebaseMessagingService {
    private static final String TAG = MyMessageService.class.getSimpleName();
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

//            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
////                scheduleJob();
//            } else {
//                // Handle message within 10 seconds
////                handleNow();
//            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("TEST_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                channel.setDescription("CHANNEL_DESCRIPTION");
                assert mNotificationManager != null;
                mNotificationManager.createNotificationChannel(channel);
            }
            Intent intent = new Intent(MyMessageService.this, SecondActivity.class);
            intent.putExtra("key", 0);
            PendingIntent pi = PendingIntent.getActivity(MyMessageService.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            Intent intent2 = new Intent(MyMessageService.this, ThirdActivity.class);
            intent2.putExtra("key", 0);
            PendingIntent pi2 = PendingIntent.getActivity(MyMessageService.this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "TEST_ID")
                    .setSmallIcon(R.drawable.ic_assistant_photo_black_24dp) // notification icon
                    .setContentTitle(remoteMessage.getNotification().getTitle()) // title for notification
                    .setContentText(remoteMessage.getNotification().getBody())// message for notification
                    .setAutoCancel(true) // clear notification after click
                    .addAction(R.drawable.ic_assistant_photo_black_24dp, "Please", pi)
                    .addAction(R.drawable.ic_assistant_photo_black_24dp, "OMG", pi2);

            mBuilder.setContentIntent(pi);
            mNotificationManager.notify(0, mBuilder.build());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
//        sendRegistrationToServer(token);
    }
}

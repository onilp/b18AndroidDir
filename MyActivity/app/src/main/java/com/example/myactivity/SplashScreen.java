package com.example.myactivity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    TextView textView;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.textView);
        handler = new Handler();

        Thread thread = new Thread(){
            int i;
            @Override
            public void run() {
                super.run();
                for(i=1; i<6; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(i));
                        }
                    });

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(SplashScreen.this, "Post Delayed", Toast.LENGTH_SHORT).show();
                        }
                    },800);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(SplashScreen.this, "RunOnUIThread", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                Intent mainActivityIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(mainActivityIntent);
            }
        };

        thread.start();
    }
}

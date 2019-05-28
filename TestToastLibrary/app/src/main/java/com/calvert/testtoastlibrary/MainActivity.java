package com.calvert.testtoastlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.calvert.toastlibrary.ToastMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToastMessage.getToast(this, "Success jitpack");
    }
}

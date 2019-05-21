package com.calvert.observer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

/**
 * Publisher: someone who give data
 */
public class SecondActivity extends AppCompatActivity {
    private EditText editText2;
    private Button submitButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        editText2 = findViewById(R.id.edittext2);
        submitButton2 = findViewById(R.id.submit_button2);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text2 = editText2.getText().toString();
                MyEventClass myEventClass = new MyEventClass();
                myEventClass.setMsg(text2);
                EventBus.getDefault().postSticky(myEventClass);
                finish();
            }
        });
    }
}

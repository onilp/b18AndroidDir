package com.calvert.observer;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Subscriber
 */
public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private Button submitButton1, fragmentSubscriberButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        editText1 = findViewById(R.id.edittext1);
        fragmentSubscriberButton = findViewById(R.id.fragment_subscriber_goto_button);
        fragmentSubscriberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_layout, new SubscriberFragment()).addToBackStack(null).commit();
            }
        });

        submitButton1 = findViewById(R.id.submit_button1);
        submitButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(secondActivityIntent);

            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void myMethod(MyEventClass myEventClass){
        myEventClass.getMsg();
        editText1.setText(myEventClass.getMsg());
    }
}

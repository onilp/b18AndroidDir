package com.calvert.observer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SubscriberFragment extends Fragment {
    private Button fragmentSubscriberButton;
    private EditText fragmentSubscriberEdittext;

    public SubscriberFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriber, container, false);

        EventBus.getDefault().register(this);

        fragmentSubscriberEdittext = view.findViewById(R.id.fragment_subscriber_et);
        fragmentSubscriberButton = view.findViewById(R.id.fragment_subscriber_button);
        fragmentSubscriberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondActivityIntent = new Intent(getContext(), SecondActivity.class);
                startActivity(secondActivityIntent);
            }
        });
        return view;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void readMessage(MyEventClass myEventClass){
        myEventClass.getMsg();
        Log.d("TAG", "readMessage: " + myEventClass.getMsg());
        fragmentSubscriberEdittext.setText(myEventClass.getMsg());
    }

}

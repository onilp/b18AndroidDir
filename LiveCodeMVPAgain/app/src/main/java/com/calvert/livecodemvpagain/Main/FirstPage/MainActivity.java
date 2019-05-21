package com.calvert.livecodemvpagain.Main.FirstPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.calvert.livecodemvpagain.R;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    EditText editText;
    TextView textView;
    Button submitButton;
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.textview);
        submitButton = findViewById(R.id.submitButton);

        presenter = new MainPresenter(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSubmitClick(editText.getText().toString());
            }
        });
    }

    @Override
    public void displayMessage(String msg) {
        textView.setText(msg);
    }
}

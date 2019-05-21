package com.calvert.livecodemvp.FirstPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.calvert.livecodemvp.R;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    EditText editText;
    Button submitButton;
    TextView textView;
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edittext);
        submitButton = findViewById(R.id.button);
        textView = findViewById(R.id.textview);
        presenter = new MainPresenter(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSubmitClicked(editText.getText().toString());   // 1, go to main presenter
            }
        });
    }

    @Override
    public void displayMessage(String msg) {
        textView.setText(msg);    // last step
    }
}

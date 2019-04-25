package com.example.register;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pageHeader;
    EditText usernameEditText, passwordEditText;
    RadioGroup genderRadioGroup;
    RadioButton genderRadioButton;
    CheckBox smartCheckBox, healthyCheckBox;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageHeader = findViewById(R.id.registerPageHeader);
        usernameEditText = findViewById(R.id.registerUsernameEditText);
        passwordEditText = findViewById(R.id.registerPasswordEditText);
        genderRadioGroup = findViewById(R.id.registerGenderRadioGroup);
        smartCheckBox = findViewById(R.id.registerSmartCheckBox);
        healthyCheckBox = findViewById(R.id.registerHealthyCheckBox);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioID = genderRadioGroup.getCheckedRadioButtonId();
                genderRadioButton = findViewById(selectedRadioID);


                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                homeIntent.putExtra("pageHeader", pageHeader.getText().toString());
                homeIntent.putExtra("username", usernameEditText.getText().toString());
                homeIntent.putExtra("password", passwordEditText.getText().toString());
                homeIntent.putExtra("gender", genderRadioButton.getText().toString());
                if(smartCheckBox.isChecked()){
                    homeIntent.putExtra("smart", smartCheckBox.getText().toString());
                }
                if(healthyCheckBox.isChecked()){
                    homeIntent.putExtra("healthy", healthyCheckBox.getText().toString());
                }
                startActivity(homeIntent);

//                Intent i =  new Intent("Cal");
//                startActivity(i);

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 00000000"));
                startActivity(intent);
            }
        });
    }
}

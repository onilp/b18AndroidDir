package com.example.threepages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    TextView redirectToLoginTextView;
    EditText registerUsernameEditText, registerPasswordEditText, registerEmailEditText;
    RadioGroup genderRadioGroup;
    RadioButton genderRadioButton;
    CheckBox registerStudentCheckBox, registerTeacherCheckBox;
    Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        redirectToLoginTextView = findViewById(R.id.redirectToLoginTextView);
        registerUsernameEditText = findViewById(R.id.registerUsernameEditText);
        registerPasswordEditText = findViewById(R.id.registerPasswordEditText);
        registerEmailEditText = findViewById(R.id.registerEmailEditText);
        genderRadioGroup = findViewById(R.id.registerGenderRadioGroup);
        registerStudentCheckBox = findViewById(R.id.registerStudentCheckBox);
        registerTeacherCheckBox = findViewById(R.id.registerTeacherCheckBox);
        registerButton = findViewById(R.id.registerButton);

        redirectToLoginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(Register.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioId = genderRadioGroup.getCheckedRadioButtonId();
                genderRadioButton = findViewById(selectedRadioId);

                Intent settingsIntent = new Intent(Register.this, Settings.class);
                settingsIntent.putExtra("username", registerUsernameEditText.getText().toString());
                settingsIntent.putExtra("password", registerPasswordEditText.getText().toString());
                settingsIntent.putExtra("gender", genderRadioButton.getText().toString());
                if(registerStudentCheckBox.isChecked()){
                    settingsIntent.putExtra("occupation", registerStudentCheckBox.getText().toString());
                }
                if(registerTeacherCheckBox.isChecked()){
                    settingsIntent.putExtra("occupation", registerTeacherCheckBox.getText().toString());
                }
                startActivity(settingsIntent);
            }
        });
    }
}

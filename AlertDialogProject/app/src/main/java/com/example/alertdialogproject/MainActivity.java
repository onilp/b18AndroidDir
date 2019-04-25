package com.example.alertdialogproject;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("My title");
                alertDialog.setMessage("Do you want to continue?");
                alertDialog.setCancelable(false);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LayoutInflater inflater = getLayoutInflater();
                        View view = inflater.inflate(R.layout.custom_toast, null);
                        Toast toast = new Toast(MainActivity.this);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER_VERTICAL, 10, 10);
                        toast.setView(view);
                        toast.show();
                    }
                });

                alertDialog.setNegativeButton("Finish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                alertDialog.show();
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog(MainActivity.this);
            }
        });
    }

    public void customDialog(final Context context) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.custom_dialog, null);
        View titleView = layoutInflater.inflate(R.layout.custom_dialog_title, null);

        TextView customDialogTitle = titleView.findViewById(R.id.customDialogTitleTextView);
        TextView customDialogBody = view.findViewById(R.id.customDialogBodyTextView);
        Button customDialogNegativeButton = view.findViewById(R.id.customDialogNegativeButton);
        Button customDialogPositiveButton = view.findViewById(R.id.customDialogPositiveButton);

        customDialogTitle.setText("Custom Dialog Title");
        customDialogBody.setText("This is a custom dialog body, yeah!");
        customDialogNegativeButton.setText("Cancel");
        customDialogPositiveButton.setText("Continue");

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setView(view).setCustomTitle(titleView);

        customDialogNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        customDialogPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Continue", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    }
}

package com.calvert.permissionexample;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.mytext);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(MainActivity.this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    requestStoragePermission();
                }
            }
        });
    }

    private void requestStoragePermission() {

        if(ActivityCompat.shouldShowRequestPermissionRationale
                (MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            AlertDialog.Builder alertDialogInstance = new AlertDialog.Builder
                    (MainActivity.this);
            alertDialogInstance
                    .setTitle("RunTime Permiss5ions")
                    .setMessage("Please allow application to write to external storage")
                    .setPositiveButton("grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            ActivityCompat.requestPermissions
                                    (MainActivity.this, new String[]
                                            {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        }
                    });

            alertDialogInstance.setNegativeButton("deny", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();

                }
            });
            alertDialogInstance.show();

        }
        else {
            ActivityCompat.requestPermissions
                    (MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);

        }
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ReadContactPermission.class);
        startActivity(intent);
    }
}


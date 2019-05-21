package com.calvert.permissionexample;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ReadContactPermission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contact_permission);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            if(ContextCompat.checkSelfPermission(ReadContactPermission.this,
                    Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(ReadContactPermission.this, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
            }
            else
            {
                requestContactPermission();
            }
        }
    }

    private void requestContactPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale
                (ReadContactPermission.this, Manifest.permission.READ_CONTACTS)){
            AlertDialog.Builder alertDialogInstance = new AlertDialog.Builder
                    (ReadContactPermission.this);
            alertDialogInstance
                    .setTitle("RunTime Permissions")
                    .setMessage("Please allow application to read and write contacts")
                    .setPositiveButton("grant", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            ActivityCompat.requestPermissions
                                    (ReadContactPermission.this, new String[]
                                            {Manifest.permission.READ_CONTACTS}, 1);
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
                    (ReadContactPermission.this, new String[]{Manifest.permission.READ_CONTACTS},1);

        }
    }
}

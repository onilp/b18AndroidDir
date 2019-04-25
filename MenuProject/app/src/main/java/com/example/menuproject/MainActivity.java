package com.example.menuproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView helloworldTextView;
    ImageView personImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloworldTextView = findViewById(R.id.helloworldTextView);
        registerForContextMenu(helloworldTextView);

        personImageView = findViewById(R.id.personImageView);
        personImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu myPop = new PopupMenu(MainActivity.this, personImageView);
                myPop.getMenuInflater().inflate(R.menu.mymenu, myPop.getMenu());
                myPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        if(id == R.id.myToast){
                            Toast.makeText(MainActivity.this, "Popup Menu Toast", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                myPop.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.myActivity:
                Toast.makeText(this, "Option activity selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.myToast:
                Toast.makeText(this, "Option toast selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.person:
                Toast.makeText(this, "Option person selected", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.myActivity:
                Toast.makeText(this, "Context activity", Toast.LENGTH_SHORT).show();
                break;

            case R.id.myToast:
                Toast.makeText(this, "Context toast", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}

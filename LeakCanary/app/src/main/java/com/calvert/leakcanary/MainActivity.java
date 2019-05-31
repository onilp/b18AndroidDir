package com.calvert.leakcanary;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.squareup.leakcanary.RefWatcher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RefWatcher refWatcher = MyApplication.getRefWatcher(this);
        refWatcher.watch(this);
        new MyAsyncTask().execute(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public class MyAsyncTask extends AsyncTask<Object, String, String> {
        private Context context;

        @Override
        protected String doInBackground(Object... params) {
            context = (Context)params[0];

            // Invoke the leak!
//            SingletonSavesContext.getInstance().setContext(context);

            // Simulate long running task
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }

            return "result";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Intent newActivity = new Intent(context, AnotherActivity.class);
            startActivity(newActivity);
        }
    }
}
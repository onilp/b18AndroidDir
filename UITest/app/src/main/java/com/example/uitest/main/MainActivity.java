package com.example.uitest.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uitest.R;

import java.util.LinkedList;

/**
* mainactivity is a view
 *
 */
public class MainActivity extends AppCompatActivity
        implements MainContract.View, AdapterView.OnItemClickListener {//4


    MainContract.Presenter presenter;//switch board ---6
    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount = 0;
   // ListView countriesListView;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);//wiring --- 6a
       // countriesListView = findViewById(R.id.countrieslistview);
       // countriesListView.setOnItemClickListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

    }

    @Override
    protected void onStart() {
        super.onStart();
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + mCount++);
            Log.d("WordList", mWordList.getLast());
        }
        mAdapter = new WordListAdapter(this, mWordList,presenter);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void clickHandler(View view) {
        //hey mr. presenter someone clicked a button
        presenter.onButtonClicked();  //---6b

        /*EditText nameEditText = findViewById(R.id.editText);
        String name = nameEditText.getText().toString();
        TextView resultTextView = findViewById(R.id.textViewResult);
        resultTextView.setText(name);*/
    }

    @Override
    public void setText(String message) {
        TextView resultTextView = findViewById(R.id.textViewResult);
        resultTextView.setText(message);
    }

    @Override
    public void showToast(String name) {
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //hey mr presenter someone clicked an item
        String name = (String) parent.getItemAtPosition(position);

        presenter.listItemClicked(name);
    }
}

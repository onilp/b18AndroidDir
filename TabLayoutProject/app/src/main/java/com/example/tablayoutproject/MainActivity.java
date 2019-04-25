package com.example.tablayoutproject;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.pager);

        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1").setIcon(R.drawable.ic_audiotrack_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // When swiping between pages, select the
        // corresponding tab.
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //actionBar.setSelectedNavigationItem(postion);
                tabLayout.setScrollPosition(position, 0, true);
                tabLayout.setSelected(true);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                EditText fruitNameEditText = findViewById(R.id.fruitNameEditText);
                TextView fruitNameTextView = findViewById(R.id.fruitNameTextView);

                fruitNameTextView.setText(fruitNameEditText.getText().toString());
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
}

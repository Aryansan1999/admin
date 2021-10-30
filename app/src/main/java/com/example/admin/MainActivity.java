package com.example.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    TableLayout tableLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(new fragmentAdapter(getSupportFragmentManager()));
        

        tableLayout=findViewById(R.id.tabLayout);
        //tableLayout.setupWithViewPager(viewPager);
    }
}
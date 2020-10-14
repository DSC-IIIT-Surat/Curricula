package com.iam844.adityajaiswal.curricula.SemesterActivity;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.iam844.adityajaiswal.curricula.Adapter.Branch5Adapter;
import com.iam844.adityajaiswal.curricula.R;

public class FifthSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth_sem);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_fifth_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("5th Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.sem5_viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        Branch5Adapter adapter = new Branch5Adapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //Setup tabs
        TabLayout tabLayout = findViewById(R.id.branch5_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}

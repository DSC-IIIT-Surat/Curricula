package com.iam844.adityajaiswal.curricula.SemesterActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.iam844.adityajaiswal.curricula.Adapter.Branch6Adapter;
import com.iam844.adityajaiswal.curricula.Adapter.Branch7Adapter;
import com.iam844.adityajaiswal.curricula.R;

public class SeventhSemActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_seventh_sem);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_seventh_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("7th Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.sem7_viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        Branch7Adapter adapter = new Branch7Adapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //Setup tabs
        TabLayout tabLayout = findViewById(R.id.branch7_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}

package com.iam844.adityajaiswal.curricula.SemesterActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.iam844.adityajaiswal.curricula.Adapter.BranchAdapter;
import com.iam844.adityajaiswal.curricula.R;

public class SemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester);

        Intent i = getIntent();
        String semesterCode = i.getExtras().getString("semesterCode");

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_subject_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle( "Semester " + semesterCode);
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.sem_viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        BranchAdapter adapter = new BranchAdapter(this, getSupportFragmentManager(), semesterCode);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //Setup tabs
        TabLayout tabLayout = findViewById(R.id.branch_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
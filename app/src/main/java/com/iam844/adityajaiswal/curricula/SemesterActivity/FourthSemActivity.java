package com.iam844.adityajaiswal.curricula.SemesterActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;

import com.iam844.adityajaiswal.curricula.Adapter.Branch4Adapter;
import com.iam844.adityajaiswal.curricula.R;

public class FourthSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_sem);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_fourth_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("4th Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.sem4_viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        Branch4Adapter adapter = new Branch4Adapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        //Setup tabs
        TabLayout tabLayout = findViewById(R.id.branch4_tabs);
        tabLayout.setupWithViewPager(viewPager);

    }
}

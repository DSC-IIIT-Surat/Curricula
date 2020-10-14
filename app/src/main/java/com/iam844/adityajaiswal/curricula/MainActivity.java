package com.iam844.adityajaiswal.curricula;

import android.content.Intent;

import android.content.SharedPreferences;
import android.net.Uri;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.widget.Toolbar;

import com.iam844.adityajaiswal.curricula.ExtraActivity.AcademicCalendarActivity;
import com.iam844.adityajaiswal.curricula.ExtraActivity.AboutActivity;
import com.iam844.adityajaiswal.curricula.Adapter.SemAdapter;
import com.iam844.adityajaiswal.curricula.Model.Semester;
import com.iam844.adityajaiswal.curricula.SemesterActivity.FifthSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.FirstSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.FourthSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.SecondSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.SixthSemActivity;
import com.iam844.adityajaiswal.curricula.SemesterActivity.ThirdSemActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final String PREFS_NAME = "key0";
    boolean lightMode;

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        //restore preferences
        SharedPreferences settings0 = this.getSharedPreferences(PREFS_NAME, 0);
        lightMode = settings0.getBoolean("key0", true);

        //retrieve selected mode
        if (lightMode) {
            //light mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            //dark mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        //Navigation Drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.NavigationDrawerOpen, R.string.NavigationDrawerClose);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Navigation View for items when tapped
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);

                int id = menuItem.getItemId();

                switch (id) {

                    case R.id.uiMode:

                        if (lightMode) {
                            //dark mode
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            lightMode = false;
                        } else {
                            //light mode
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            lightMode = true;
                        }

                        SharedPreferences setting0 = getSharedPreferences(PREFS_NAME, 0);
                        SharedPreferences.Editor editor0 = setting0.edit();
                        editor0.putBoolean("key0", lightMode);
                        editor0.apply();

                        return true;

                    case R.id.nav_academic_calendar:

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent academiccalendar = new Intent(MainActivity.this, AcademicCalendarActivity.class);
                        startActivity(academiccalendar);

                        return true;

//                    case R.id.nav_firstyear_timetable:
                    // close drawer when item is tapped
//                    mDrawerLayout.closeDrawers();
//
//                        Intent firstyear = new Intent(MainActivity.this, FirstYearTimeTableActivity.class);
//                        startActivity(firstyear);
//
//                        return true;

//                    case R.id.nav_secondyear_timetable:
// close drawer when item is tapped
//                mDrawerLayout.closeDrawers();
//                        Intent secondyear = new Intent(MainActivity.this, SecondYearTimeTableActivity.class);
//                        startActivity(secondyear);
//
//                        return true;

                    case R.id.nav_add_materials:

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent intentAddMaterial = new Intent(Intent.ACTION_VIEW);
                        intentAddMaterial.setData(Uri.parse("https://drive.google.com/drive/folders/1DzCTj34XOVlmk2pmAMtCr8GMtECjRBa4?usp=sharing"));
                        if (intentAddMaterial.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentAddMaterial);
                        }
                        return true;

                    case R.id.nav_feedback:

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent intentFeedback = new Intent(Intent.ACTION_SENDTO);
                        intentFeedback.setData(Uri.parse("mailto:appcurricula@gmail.com")); // only email apps should handle this
                        if (intentFeedback.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentFeedback);
                        }
                        return true;

                    case R.id.nav_contribute:

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent intentContribute = new Intent(Intent.ACTION_VIEW);
                        intentContribute.setData(Uri.parse("https://github.com/iam844/Curricula-1.0"));
                        if (intentContribute.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentContribute);
                        }
                        return true;

                    case R.id.nav_share_app:

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        Intent intentShareApp = new Intent(android.content.Intent.ACTION_SEND);
                        intentShareApp.setType("text/plain");
                        String shareBody = "https://play.google.com/store/apps/details?id=com.iam844.adityajaiswal.curricula";
                        intentShareApp.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        intentShareApp.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(intentShareApp, "Share via"));

                    default:
                        return true;
                }

            }
        });

        //Content
        GridView semGridView = findViewById(R.id.semGridView);

        final ArrayList<Semester> semList = new ArrayList<>();

        semList.add(new Semester(R.drawable.ic_sem1, FirstSemActivity.class));
        semList.add(new Semester(R.drawable.ic_sem2, SecondSemActivity.class));
        semList.add(new Semester(R.drawable.ic_sem3, ThirdSemActivity.class));
        semList.add(new Semester(R.drawable.ic_sem4, FourthSemActivity.class));
        semList.add(new Semester(R.drawable.ic_sem5, FifthSemActivity.class));
        semList.add(new Semester(R.drawable.ic_sem6, SixthSemActivity.class));
//        semList.add(new Semester(R.drawable.ic_sem7, FourthSemActivity.class));
//        semList.add(new Semester(R.drawable.ic_sem8, FourthSemActivity.class));

        // Create an object of SemAdapter and set Adapter to GirdView
        SemAdapter objSemAdapter = new SemAdapter(this, R.layout.sem_item, semList);
        semGridView.setAdapter(objSemAdapter);

        // Implement setOnItemClickListener event on GridView
        semGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                startActivity(new Intent(MainActivity.this, semList.get(position).getSemActivity()));

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.menu_about:

                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

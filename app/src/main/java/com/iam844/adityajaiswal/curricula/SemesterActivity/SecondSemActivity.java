package com.iam844.adityajaiswal.curricula.SemesterActivity;

import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;
import com.iam844.adityajaiswal.curricula.Sem2Activity.DSA2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.DM2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.DLD2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.EDC2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.SS2Activity;
import com.iam844.adityajaiswal.curricula.Sem2Activity.EM2Activity;

import java.util.ArrayList;

public class SecondSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sem);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_second_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("2nd Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Data Structures and Algorithm", "CS 201", R.drawable.ic_dsa2, DSA2Activity.class));
        subjectList.add(new Subject("Electronic Devices and Circuits", "EC 202", R.drawable.ic_edc2, EDC2Activity.class));
        subjectList.add(new Subject("Engineering Mechanics", "AE 203", R.drawable.ic_em2, EM2Activity.class));
        subjectList.add(new Subject("Digital Logic Design", "EC 204", R.drawable.ic_dld2, DLD2Activity.class));
        subjectList.add(new Subject("Discrete Mathematics", "AS 205", R.drawable.ic_dm2, DM2Activity.class));
        subjectList.add(new Subject("Signal and Systems", "EC 206", R.drawable.ic_ss2, SS2Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem2listView = findViewById(R.id.sem2_listView);
        SubjectAdapter objSubAdapter = new SubjectAdapter(this, R.layout.subject_item, subjectList);
        sem2listView.setAdapter(objSubAdapter);

        //Click listeners
        sem2listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(SecondSemActivity.this, subjectList.get(position).getSubActivity()));
            }
        });
    }
}
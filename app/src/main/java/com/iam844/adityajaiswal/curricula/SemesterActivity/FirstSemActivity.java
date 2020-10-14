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

import com.iam844.adityajaiswal.curricula.Sem1Activity.ECS1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.EN1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.EM1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.EP1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.FCP1Activity;
import com.iam844.adityajaiswal.curricula.Sem1Activity.ICTOne1Activity;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;

import java.util.ArrayList;

public class FirstSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_sem);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_first_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("1st Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Fundamentals of Computers & Programming", "CS 101", R.drawable.ic_fcp1, FCP1Activity.class));
        subjectList.add(new Subject("English and Communication Skills", "AL 102", R.drawable.ic_ecs1, ECS1Activity.class));
        subjectList.add(new Subject("Engineering Physics", "AS 103", R.drawable.ic_ep1, EP1Activity.class));
        subjectList.add(new Subject("Electrical Networks","EE 104", R.drawable.ic_en1, EN1Activity.class));
        subjectList.add(new Subject("Engineering Mathematics", "AS 105", R.drawable.ic_em1, EM1Activity.class));
        subjectList.add(new Subject("ICT Workshop - I", "EC 106", R.drawable.ic_ictone1, ICTOne1Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem1listView = findViewById(R.id.sem1_listView);
        final SubjectAdapter objSubAdapter = new SubjectAdapter(this, R.layout.subject_item, subjectList);
        sem1listView.setAdapter(objSubAdapter);

        //Click listeners
        sem1listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(FirstSemActivity.this, subjectList.get(position).getSubActivity()));
            }
        });

    }

}

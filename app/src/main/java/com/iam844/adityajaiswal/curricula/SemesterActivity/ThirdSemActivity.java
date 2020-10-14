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

import com.iam844.adityajaiswal.curricula.Sem3Activity.AFL3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.CE3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.CO3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.EC3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.MPI3Activity;
import com.iam844.adityajaiswal.curricula.Sem3Activity.PSA3Activity;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;

import java.util.ArrayList;

public class ThirdSemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_sem);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_third_sem);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("3rd Semester");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Computer Organization", "CS 301", R.drawable.ic_co3, CO3Activity.class));
        subjectList.add(new Subject("Microprocessor and Interfacing", "EC 302", R.drawable.ic_mpi3, MPI3Activity.class));
        subjectList.add(new Subject("Communication Engineering", "EC 303", R.drawable.ic_ce3, CE3Activity.class));
        subjectList.add(new Subject("Automata Formal Languages", "CS 304", R.drawable.ic_afl3, AFL3Activity.class));
        subjectList.add(new Subject("Electronic Circuits", "EC 304", R.drawable.ic_ec3, EC3Activity.class));
        subjectList.add(new Subject("Probability and Statistical Analysis", "AS 305", R.drawable.ic_psa3, PSA3Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem3listView = findViewById(R.id.sem3_listView);
        SubjectAdapter objSubAdapter = new SubjectAdapter(this, R.layout.subject_item, subjectList);
        sem3listView.setAdapter(objSubAdapter);

        //Click listeners
        sem3listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(ThirdSemActivity.this, subjectList.get(position).getSubActivity()));

            }
        });
    }
}
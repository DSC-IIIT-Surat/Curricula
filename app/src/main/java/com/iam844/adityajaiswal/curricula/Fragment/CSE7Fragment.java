package com.iam844.adityajaiswal.curricula.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Sem6Activity.ADBMS6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.AVR6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.CCBD6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.HPC6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.IML6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.WE6Activity;
import com.iam844.adityajaiswal.curricula.Sem7Activity.AIActivity;
import com.iam844.adityajaiswal.curricula.SubjectContentActivity;

import java.util.ArrayList;

public class CSE7Fragment extends Fragment {

    public CSE7Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.branch_fragment_list, container, false);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Artificial Intelligence", "CS 701", R.drawable.ic_iml6, SubjectContentActivity.class));
        subjectList.add(new Subject("Network Security", "CS 702", R.drawable.ic_hpc6, HPC6Activity.class));
        subjectList.add(new Subject("Natural Language Processing", "CS 703", R.drawable.ic_we6, WE6Activity.class));
        subjectList.add(new Subject("Innovation & Entrepreneurship", "AE 704", R.drawable.ic_adbms6, ADBMS6Activity.class));
        subjectList.add(new Subject("Block-Chain and Ledger", "CS 751", R.drawable.ic_ccbd6, CCBD6Activity.class));
        subjectList.add(new Subject("Computer Ethics & Public Policy", "CS 761", R.drawable.ic_avr6, AVR6Activity.class));
        subjectList.add(new Subject("Web 2.0", "CS 762", R.drawable.ic_avr6, AVR6Activity.class));


        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem4cseListView = rootView.findViewById(R.id.branch_list);
        SubjectAdapter objSubAdapter = new SubjectAdapter(getActivity(), R.layout.subject_item, subjectList);

        sem4cseListView.setAdapter(objSubAdapter);

        //Click listeners
        sem4cseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(getActivity(), subjectList.get(position).getSubActivity());

                intent.putExtra("subjectCode", subjectList.get(position).getSubCodeListName());
                intent.putExtra("semesterCode", "7");
                startActivity(intent);

            }
        });

        return rootView;
    }
}

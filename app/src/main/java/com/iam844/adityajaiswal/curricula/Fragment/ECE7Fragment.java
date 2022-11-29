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
import com.iam844.adityajaiswal.curricula.Sem6Activity.AVR6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.CCBD6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.ES6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.IML6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.DVD6Activity;
import com.iam844.adityajaiswal.curricula.Sem6Activity.WE6Activity;

import java.util.ArrayList;

public class ECE7Fragment extends Fragment {

    public ECE7Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.branch_fragment_list, container, false);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Artificial Intelligence", "CS 701", R.drawable.ic_iml6, IML6Activity.class));
        subjectList.add(new Subject("Internet of Things", "EC 702", R.drawable.ic_dvd6, DVD6Activity.class));
        subjectList.add(new Subject("Image Processing and Computer Vision", "EC 703", R.drawable.ic_we6, WE6Activity.class));
        subjectList.add(new Subject("Innovation and Entrepreneurship", "AE 704", R.drawable.ic_es6, ES6Activity.class));
        subjectList.add(new Subject("Block-chain Technology", "CS 751", R.drawable.ic_ccbd6, CCBD6Activity.class));
        subjectList.add(new Subject("Computer Ethics and Public Policy", "CS 761", R.drawable.ic_avr6, AVR6Activity.class));
        subjectList.add(new Subject("Web 2.0", "CS 762", R.drawable.ic_avr6, AVR6Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem4cseListView = rootView.findViewById(R.id.branch_list);
        SubjectAdapter objSubAdapter = new SubjectAdapter(getActivity(), R.layout.subject_item, subjectList);

        sem4cseListView.setAdapter(objSubAdapter);

        //Click listeners
        sem4cseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(getActivity(), subjectList.get(position).getSubActivity()));

            }
        });

        return rootView;
    }
}

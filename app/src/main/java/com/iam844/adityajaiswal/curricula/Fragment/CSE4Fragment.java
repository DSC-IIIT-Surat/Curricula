package com.iam844.adityajaiswal.curricula.Fragment;

import android.content.Intent;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;
import com.iam844.adityajaiswal.curricula.Sem4Activity.CN4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.DAA4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.DBMS4Activity;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.Sem4Activity.OOT4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.OS4Activity;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.Sem4Activity.SS4Activity;

import java.util.ArrayList;

public class CSE4Fragment extends Fragment {

    public CSE4Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.branch_fragment_list, container, false);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Operating Systems", "CS 401", R.drawable.ic_os4, OS4Activity.class));
        subjectList.add(new Subject("Computer Networks", "CS 402", R.drawable.ic_cn4, CN4Activity.class));
        subjectList.add(new Subject("Database Management System", "CS 403", R.drawable.ic_dbms4, DBMS4Activity.class));
        subjectList.add(new Subject("Object Oriented Technology", "CS 404", R.drawable.ic_oot4, OOT4Activity.class));
        subjectList.add(new Subject("System Software", "CS 405", R.drawable.ic_ss4, SS4Activity.class));
        subjectList.add(new Subject("Design and Analysis of Algorithms", "CS 406", R.drawable.ic_daa4, DAA4Activity.class));

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

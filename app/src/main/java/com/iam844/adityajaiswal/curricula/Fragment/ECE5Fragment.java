package com.iam844.adityajaiswal.curricula.Fragment;

import android.app.Activity;
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
import com.iam844.adityajaiswal.curricula.Sem4Activity.AC4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.CN4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.DC4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.EMW4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.MC4Activity;
import com.iam844.adityajaiswal.curricula.Sem4Activity.OS4Activity;
import com.iam844.adityajaiswal.curricula.Sem5Activity.CS5Activity;
import com.iam844.adityajaiswal.curricula.Sem5Activity.DIC5Activity;
import com.iam844.adityajaiswal.curricula.Sem5Activity.DSP5Activity;
import com.iam844.adityajaiswal.curricula.Sem5Activity.EBM5Activity;
import com.iam844.adityajaiswal.curricula.Sem5Activity.FLNN5Activity;
import com.iam844.adityajaiswal.curricula.Sem5Activity.NMUP5Activity;

import java.util.ArrayList;

public class ECE5Fragment extends Fragment {

    public ECE5Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.branch_fragment_list, container, false);

        //Create list of data
        final ArrayList<Subject> subjectList = new ArrayList<>();

        subjectList.add(new Subject("Control System", "EE 501", R.drawable.ic_cs5, CS5Activity.class));
        subjectList.add(new Subject("Digital Integrated Circuit", "EC 502", R.drawable.ic_dic5, DIC5Activity.class));
        subjectList.add(new Subject("Digital Signal Processing", "EC 503", R.drawable.ic_dsp5, DSP5Activity.class));
        subjectList.add(new Subject("Economics & Business Management", "AE 504", R.drawable.ic_ebm5, EBM5Activity.class));
        subjectList.add(new Subject("Numerical Methods Using Python", "CS 511", R.drawable.ic_nmup5, NMUP5Activity.class));
        subjectList.add(new Subject("Fuzzy Logic & Neural Network", "CS 521", R.drawable.ic_flnn5, FLNN5Activity.class));

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView sem4eceListView = rootView.findViewById(R.id.branch_list);
        SubjectAdapter objSubAdapter = new SubjectAdapter(getActivity(), R.layout.subject_item, subjectList);

        sem4eceListView.setAdapter(objSubAdapter);

        //Click listeners
        sem4eceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                startActivity(new Intent(getActivity(), subjectList.get(position).getSubActivity()));

            }
        });

        return rootView;
    }
}

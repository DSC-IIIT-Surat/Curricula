package com.iam844.adityajaiswal.curricula.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.iam844.adityajaiswal.curricula.Adapter.SubjectAdapter;
import com.iam844.adityajaiswal.curricula.IconData;
import com.iam844.adityajaiswal.curricula.Model.Subject;
import com.iam844.adityajaiswal.curricula.R;
import com.iam844.adityajaiswal.curricula.SubjectContentActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class CSEFragment extends Fragment {

    private String semesterCode;
    private ArrayList<Subject> subjectList;

    public CSEFragment(String semCode) {
        semesterCode = semCode;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.cse_subject_list, container, false);
        subjectList = new ArrayList<>();
        readFile();

        // Create an object of SubjectAdapter and ListView, then set Adapter to ListView
        ListView cseListView = rootView.findViewById(R.id.subject_list);
        SubjectAdapter objSubAdapter = new SubjectAdapter(getActivity(), R.layout.subject_item, subjectList);

        cseListView.setAdapter(objSubAdapter);

        //Click listeners
        cseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent intent = new Intent(getActivity(), subjectList.get(position).getSubActivity());

                intent.putExtra("subjectCode", subjectList.get(position).getSubCodeListName());
                intent.putExtra("semesterCode", semesterCode);
                startActivity(intent);

            }
        });

        return rootView;

    }

    public void readFile() {
        InputStream is = getResources().openRawResource(R.raw.data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = writer.toString();

        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray allSubjects = obj.getJSONObject("semester").getJSONArray(semesterCode);

            for (int i = 0; i < allSubjects.length(); i++) {

                JSONObject tempSub = allSubjects.getJSONObject(i);
                System.out.println(tempSub);
                if (tempSub.getBoolean("cse")) {
                    IconData icons = new IconData();
                    HashMap<String, Integer> iconMap = icons.getIconData();

                    Integer iconResId = iconMap.get(tempSub.getString("icon"));

                    subjectList.add(new Subject(tempSub.getString("name"), tempSub.getString("code"),
                           iconResId  , SubjectContentActivity.class));
                }
            }


        } catch (JSONException e) {
            System.out.println(e);
        }
    }
}

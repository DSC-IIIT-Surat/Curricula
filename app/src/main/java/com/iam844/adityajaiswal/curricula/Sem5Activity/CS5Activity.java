package com.iam844.adityajaiswal.curricula.Sem5Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.iam844.adityajaiswal.curricula.Adapter.MaterialExpandableListAdapter;
import com.iam844.adityajaiswal.curricula.Model.DataURL;
import com.iam844.adityajaiswal.curricula.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CS5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_cs5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Control System");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.cs5_listView);
        initData();
        listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if(listHash.get(listDataHeader.get(i)).get(i1).getmURL() == null ){
                    Toast.makeText(getApplicationContext(), "Will be updated soon!", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(listHash.get(listDataHeader.get(i)).get(i1).getmURL()));
                    startActivity(intent);

                }

                return false;
            }
        });

    }

    public void initData() {
        listDataHeader = new ArrayList<>();     //Group list
        listHash = new HashMap<>();             //Child List

        //Header
        listDataHeader.add("Class Materials");
//        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Control System Notes","https://drive.google.com/open?id=12VLJlXUyDZsrG-XO-7GZoDmz-gFp8qal"));
        classMaterials.add(new DataURL("CS MidSem19 ","https://drive.google.com/open?id=1tQC8J7_ZerC0ZYdEpDr1z20J4QXyVt0C"));
        classMaterials.add(new DataURL("CS EndSem19","https://drive.google.com/open?id=1bypc5k9s5IE9VBFH4lNz6DVN6zKOBLYC"));

//        List<DataURL> books = new ArrayList<>();

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1NRLPYDXXJpic9uyUBv_gt9ZtRQm7T18R"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=1BnuXeyvV3ZHo5k9hLGVmlYiVE89bZh0z"));


        listHash.put(listDataHeader.get(0), classMaterials);
//        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(1), examPapers);
    }

}

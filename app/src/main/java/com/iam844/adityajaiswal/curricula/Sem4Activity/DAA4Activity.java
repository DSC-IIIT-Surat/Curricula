package com.iam844.adityajaiswal.curricula.Sem4Activity;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.iam844.adityajaiswal.curricula.Adapter.MaterialExpandableListAdapter;
import com.iam844.adityajaiswal.curricula.Model.DataURL;
import com.iam844.adityajaiswal.curricula.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAA4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daa4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_daa4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Design and Analysis of Algorithm");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.daa4_listView);
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

                    Toast.makeText(getApplicationContext(),
                            listDataHeader.get(i) + " : " + listHash.get(listDataHeader.get(i)).get(i1).getmName(),
                            Toast.LENGTH_SHORT).show();
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
        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Greedy Design Techniques","https://drive.google.com/open?id=1mcQq3k1NZsDqZrmjbexmFftsDPWSS4BF"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Data Structures Algorithms and Applications in C - Sartraj Sahani","https://drive.google.com/open?id=1PvnYnzvAEHAVxCFsR-bTENEBZZ-H7GLs"));
        books.add(new DataURL("Algorithm Design - John Kleinberg - Éva Tardos","https://drive.google.com/open?id=118IdjlJAI04dfA1rPbH1xDhwy9ZxBa40"));
        books.add(new DataURL("Introduction to Algorithms","https://drive.google.com/open?id=1aXqdZQpC4GzLs4S3EhdjgXsLKOaJCZE6"));
        books.add(new DataURL("Cormen Lin Lee - Introduction to Algorithms (Solutions)","https://drive.google.com/open?id=1wQxfgSvbdMQDzhU965Y5oWaP_enys0a9"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1SSw_CX60SW9wW5DgLOUhYC9wghRQ6xdm"));
        examPapers.add(new DataURL("MidSem 20","https://drive.google.com/open?id=14blepBeUZcOsAXppkB3v32eOkVbcz9va"));

//        examPapers.add(new DataURL("EndSem 19"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
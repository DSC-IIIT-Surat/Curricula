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

public class AC4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ac4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Analog Circuits");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ac4_listView);
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
        listDataHeader.add("New Material");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("AC Notes Mid Sem","https://drive.google.com/open?id=1TcYRlcFoEJyDFtMbSf4YmU7F0yMOCuxt"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("S Franco Design With Operational Amplifiers and Analog Integrated Circuits","https://drive.google.com/open?id=1MAIsShiVLjYiq8XAqHpBSMYKcJ-lQj9b"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1C-6KFgICPsb9XQYI_rD_kR0e8UbUULJ8"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=16_3LbepRM1xtC03g4TPxc5xoB5apgQNl"));
        examPapers.add(new DataURL("MidSem 20","https://drive.google.com/open?id=1OaJIyNVvzoVHO2TAr_Xyn6_GVdJBpvjC"));

        List<DataURL>  newMaterial=new ArrayList<>();
        newMaterial.add(new DataURL("AC Assignment 1","https://drive.google.com/open?id=1KwjFHcNeWXZNsFMDTlAteCC9LNQRyINc"));
        newMaterial.add(new DataURL("AC Active Filter Notes","https://drive.google.com/open?id=1mbJkgrIb2cXxOulfxt66E1errft3s7Sv"));
        newMaterial.add(new DataURL("Analog to Digital & Digital to Analog Converters","https://drive.google.com/open?id=15rduuXDg_1OVYM2-0RFZXrcniuXfAw9A"));
        newMaterial.add(new DataURL("AC Multiple Feedback & SV Filters","https://drive.google.com/open?id=1SqrElPlbF0_9aaEDAVJdHNY8qAyVu0xB"));
        newMaterial.add(new DataURL("AC Second Order Active Filters","https://drive.google.com/open?id=1Fi64eODXIwW9D89hBOB7gMgWRqAGI38M"));
        newMaterial.add(new DataURL("AC Second Order Cascade Filters","https://drive.google.com/open?id=1v0UNUL14weiUe4b_3O2ZUBKEnzTbUhRd"));
        newMaterial.add(new DataURL("NPTEL Video Link","https://drive.google.com/open?id=1mkC5cGFN_vkQpXzM_5D9qxYajnTUePmH"));
        newMaterial.add(new DataURL("Solution AC Assignment 1","https://drive.google.com/open?id=1B3P0s3aiHd736TDvHjV-Dsg03qPHxZF8"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3),newMaterial);
    }

}
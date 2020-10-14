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

public class OS4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_os4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Operating Systems");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.os4_listView);
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
        classMaterials.add(new DataURL("Virtual Memory","https://drive.google.com/open?id=1o3tkD-KjvFZgpVHQyC_JGhyBpwz13i5L"));
        classMaterials.add(new DataURL("Chapter 1","https://drive.google.com/open?id=1GVmO03N9xPmsEIZ44lLP_PoPYyEkmQTR"));
        classMaterials.add(new DataURL("Chapter 2","https://drive.google.com/open?id=1VtmGbMIcI8E2i2wRmnKXE-ZKP2jbnw9T"));
        classMaterials.add(new DataURL("Chapter 3","https://drive.google.com/open?id=1SAmDpUdTXtmHZaFhMKgf3hru7jArqHES"));
        classMaterials.add(new DataURL("Chapter 4","https://drive.google.com/open?id=14JAJ0ihQTqlosRskq3_CGYRpgSEcyqNy"));
        classMaterials.add(new DataURL("Chapter 5","https://drive.google.com/open?id=1yiKySxCZHPbDcLvc9oAyaVrxCRGxEExI"));
        classMaterials.add(new DataURL("Chapter 6","https://drive.google.com/open?id=18nwkAajHXc26CMySJGRhFURDH6TQBSKE"));
        classMaterials.add(new DataURL("Chapter 7","https://drive.google.com/open?id=1USXmjHQpwD-aTEsHGjrf6Z_8csgXakjn"));
        classMaterials.add(new DataURL("Chapter 8","https://drive.google.com/open?id=1ZsKt3-w8u7-cz_cc2LfrLP4-cKbHUY5l"));
        classMaterials.add(new DataURL("Chapter 9","https://drive.google.com/open?id=1sHDNa3GzwkFmsjmuqUXEwQKsEcrA_VOJ"));
        classMaterials.add(new DataURL("OS EndSem Notes","https://drive.google.com/open?id=1iFnnnW-QUxdSEUiJDbl9FZmjAXa6eiCP"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Operating System - William Stallings","https://drive.google.com/open?id=1x3cv4Axf2Q8KcB5uRebhjaJL8CfXR2aT"));
        books.add(new DataURL("William Stallings Solution","https://drive.google.com/open?id=1N57tBsk-oA5p7ErUc2m6YFJ7BTf0UmYQ"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1s89Kr8-rauwYQDW3wBB-csJ3y3BPSFN5"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=1Iqp6AioziM3BkMIzA376Wh8FXfUwTXHy"));
        examPapers.add(new DataURL("MidSem 20","https://drive.google.com/open?id=1M9W_jglxRsPmKBK1TY3J5Jl_t_BIGkuf"));

        List<DataURL> newMaterial=new ArrayList<>();
        newMaterial.add(new DataURL("Synchronization mechanism software based solution case studies","https://drive.google.com/open?id=1URslYUeQKlBFFK_aJvT3tgr2jsRvgvSZ"));


        listHash.put(listDataHeader.get(3),newMaterial);
        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
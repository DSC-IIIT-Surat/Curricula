package com.iam844.adityajaiswal.curricula.Sem6Activity;

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

public class ADBMS6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adbms6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_adbms6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Advance DBMS");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.adbms6_listView);
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
        listDataHeader.add("Books");
//        listDataHeader.add("Exam Papers");
//        listDataHeader.add("New Material");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Introduction","https://drive.google.com/open?id=1H88rE3_RZyVfTBlME1pwP77zNhUSnfpO"));
        classMaterials.add(new DataURL("Reliability and Availability","https://drive.google.com/open?id=1hl5Ku3Y0gY6RmhOXlgnowwSztIB26W8KK76SJYtrRiQ"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Distributed Database Management System 'A practical Approach'","https://drive.google.com/open?id=155MnNSNXiT-7zcFb_7BGl3LYHPZi6T_f"));
        books.add(new DataURL("Principles of Distributed database","https://drive.google.com/open?id=1PVMnvUDXKJVNILdTiGr_M6p3u5DDPQLZ"));

//        List<DataURL> examPapers = new ArrayList<>();
        //examPapers.add(new DataURL("New Material will be updated ASAP",""));

//        List<DataURL> newMaterial= new ArrayList<>();

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
//        listHash.put(listDataHeader.get(2), examPapers);
//        listHash.put(listDataHeader.get(3), newMaterial);
    }
}

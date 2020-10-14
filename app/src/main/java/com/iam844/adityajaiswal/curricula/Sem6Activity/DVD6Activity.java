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

public class DVD6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvd6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dvd6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Digital VLSI Design");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dvd6_listView);
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
        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("ADD Dynamic Logic","https://drive.google.com/open?id=1GKhTyCMdwtBeZ29AiNbQMH51xisT-XdI"));
        classMaterials.add(new DataURL("ASIC Design Flow","https://drive.google.com/open?id=1em_2iGjc93zlRJT6-OFVWjzUdk4UGUhn"));
        classMaterials.add(new DataURL("Coping with Interconnects","https://drive.google.com/open?id=1KRuuEqM1woj9TEiX1w9FHB_hAviqCfUY"));
        classMaterials.add(new DataURL("Suraj Sir Notes","https://drive.google.com/open?id=1EALod7cFpfyTUusZD1wkyrFjunw_DmCy"));
        classMaterials.add(new DataURL("Pass Translator Logic","https://drive.google.com/open?id=1YP3w42f2uCGpiXgCgVA9O7dD1YRZaJJt"));
        classMaterials.add(new DataURL("The Wire Interconnects","https://drive.google.com/open?id=1g5DiTK_Rm7fTWVkquLUdldovYC5qcpnO"));


        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Interconnect By Kang","https://drive.google.com/open?id=1S9WPBcl717dJRoWeBCHJO-Zwx6kCF80B"));
        books.add(new DataURL("Rabaey Digital Integrated Circuits","https://drive.google.com/open?id=16poStgBKTFteeqcqIH5My_IfuWjvVPtO"));
        books.add(new DataURL("The Wire(Ch 4 Rabaey)","https://drive.google.com/open?id=1Qq1mpCBdXOvrEh2Uy3DJh4BzrgPc4dBZ"));


        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 2020", "https://drive.google.com/open?id=1dvAtWotn2a4KP8pXHBn12WOLGV5U5qjb"));
//        examPapers.add(new DataURL("EndSem 19"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }
}

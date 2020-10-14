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

public class DC4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dc4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dc4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Digital Communications");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dc4_listView);
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
        classMaterials.add(new DataURL("Baseband Communication","https://drive.google.com/open?id=1-46cZYCpV4aD9i0GJo5lsOfdBpunqJwX"));
        classMaterials.add(new DataURL("Principles Of Digital Data Communication","https://drive.google.com/open?id=1B1w1EtjQJwMGfPnwmXvsZGKgPpb_SyaR"));
        classMaterials.add(new DataURL("TDM Pulse Code Modulation Transmitter and Receiver Trainer ST2153 and ST2154 Operating","https://drive.google.com/open?id=1ssJED11dtuFirtNsHm_fq_Ds63G95TZn"));

        List<DataURL> newMaterial = new ArrayList<>();
        newMaterial.add(new DataURL("Correlative Coding","https://drive.google.com/open?id=1OpLGsRTaKTH_YSJYv18frnEGBwAlA2PG"));
        newMaterial.add(new DataURL("Assignment 2","https://drive.google.com/open?id=1OUvPo1BgshReyqjBAsfCCBfNuS_sbRMa"));
        newMaterial.add(new DataURL("Channel Capacity of Continuous Memory Less Channel","https://drive.google.com/open?id=1ZRQJ6FPnImjFn0R6uvPdIp8f-edySeo1"));
        newMaterial.add(new DataURL("Channel Coding 1","https://drive.google.com/open?id=1tCRK1XhdyIBPmJZWP9IriY8Q1J0_dQv3"));
        newMaterial.add(new DataURL("Channel Coding 2","https://drive.google.com/open?id=1H8eMVlHcJU99912Az9fiDAJ3xf5Wc9T2"));
        newMaterial.add(new DataURL("Cyclic Coding & Convolution Code","https://drive.google.com/open?id=1nriqxsaUdYGymZPhXUyR4gK3b9wogXon"));
        newMaterial.add(new DataURL("Capacity of a Band-Limited AWGN Channel","https://drive.google.com/open?id=12DA4SxiukxRqRj4WNYwZPDnHjzHfmHNT"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("EMPTY!"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1KRKwaCIezNmLjPutbJ1s0GtAHoqPj_am"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=1YC1Xq4ian1vTdfw9mwII16Uafs7nQ3Fh"));
        examPapers.add(new DataURL("MidSem 20","https://drive.google.com/open?id=1o1VvvFlg6UGZIyM6lgVl6avAdsbAqg5r"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3),newMaterial);
    }

}
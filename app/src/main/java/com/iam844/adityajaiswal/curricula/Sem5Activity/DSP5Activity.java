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

public class DSP5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsp5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dsp5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Digital Signal Processing");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dsp5_listView);
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
        classMaterials.add(new DataURL("Assignment-1","https://drive.google.com/open?id=1pVeavWLCdru5iFCLL5jYXEyI7CtRoo7M"));
        classMaterials.add(new DataURL("Implementation of Discrete-Time Systems","https://drive.google.com/open?id=16LyuIO4bWqZZzPewP1HYlCyjQZzh1qVz"));
        classMaterials.add(new DataURL("Multiple Digital Signal Processing","https://drive.google.com/open?id=1zJhSfQ5vkD57pTgGkJcfthrf3qnbGOdE"));
        classMaterials.add(new DataURL("Design of Digital Filter","https://drive.google.com/open?id=1-xyp8gOm-DokXuFQVoihPOtSIzRTmEpp"));
        classMaterials.add(new DataURL("DFT & FFT Algorithms","https://drive.google.com/open?id=1O5QmIvhyrGZw5PZxsrgaBi8lmI-0meBw"));
        classMaterials.add(new DataURL("Discrete Time Systems","https://drive.google.com/open?id=1vkN0HInJZA-9UlVuUBgAPKWieXJ_W4Be"));
        classMaterials.add(new DataURL("After MidSem Written Notes 1","https://drive.google.com/open?id=10b1FPai2EpQoRlbygHWW2HOTahtpjTlX"));
        classMaterials.add(new DataURL("After MidSem Written Notes 2","https://drive.google.com/open?id=1Y4nXh9bQ7PjDEbxvAzC6sZu8rrtTgvEV"));
        classMaterials.add(new DataURL("MidSem written Notes ","https://drive.google.com/open?id=1IuhPddorS65f60_L06bkpd0cLKH3i5FQ"));
        classMaterials.add(new DataURL("Structure/Implementation of Discrete-Time System","https://drive.google.com/open?id=13mAe_n0OIeyT0ZmkrAH8u4wqYI_Tmgsx"));
        classMaterials.add(new DataURL("Basics of Linear Phase FIR Filter","https://drive.google.com/open?id=1Lmkq2pn0xJ6fiOOSuDuJqP6pe4UUdTrN"));
        classMaterials.add(new DataURL("Structure of FIR & IIR Systems","https://drive.google.com/open?id=1Fo4yaIgt_S9ypueWh-99jOCkcbGzcZWG"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Digital Signal Processing","https://drive.google.com/open?id=1UIpCyak3CpdmTONDFNAItXFKWICpzGxR"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1wlszuGgxh7yeinW8W2faULfxO9iXptV3"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}

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

public class ES6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_es6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_es6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Embedded System");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.es6_listView);
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
        listDataHeader.add("New Material");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Embedded System Design","https://drive.google.com/open?id=16wBmKODJLiNuZJcjIJ0y3x7h4aOCyfc9"));
        classMaterials.add(new DataURL("ARM Cortex M Processor","https://drive.google.com/open?id=1mYSjJGmkpG3MlMxkMChcRBrpkwQ-jVnM"));
        classMaterials.add(new DataURL("Introduction","https://drive.google.com/open?id=1iGAyLvLPUJE8wnRtEXH4MrpjSXt8eMiP"));
        classMaterials.add(new DataURL("Lab-Aims","https://drive.google.com/open?id=1Lzf3QHUDApiVOZVTtYcwiMwk5_hrvCy6"));
        classMaterials.add(new DataURL("LED","https://drive.google.com/open?id=16J9pPNL80CgJ-c5z4MlHj-6UOSipf0e2"));
        classMaterials.add(new DataURL("Programming For ARM Cortex M0 Processore","https://drive.google.com/open?id=1ZX2Kxrc_88-XixIzvJOMLv8e5RWShLjj"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Freescale ARM Cortex-M Embedded Programming","https://drive.google.com/open?id=1FLdPtauDhRu0uvdeGlpYv6hgRdLiQcPB"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 2020", "https://drive.google.com/open?id=1sm-o37ss_7W22xXda_udthBQfjVWQZ5Y"));
//        examPapers.add(new DataURL("EndSem 19"));

        List<DataURL> newMaterial = new ArrayList<>();
         newMaterial.add(new DataURL("RTOS Based Embedded System Design ","https://drive.google.com/open?id=1JGkGqtXMGP8zsuNurBh_SVcw07Tiga_z"));
        //newMaterial.add(new DataURL(" ",""));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3), newMaterial);
    }
}

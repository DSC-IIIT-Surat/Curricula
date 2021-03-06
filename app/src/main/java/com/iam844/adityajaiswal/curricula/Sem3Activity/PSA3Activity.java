package com.iam844.adityajaiswal.curricula.Sem3Activity;

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

public class PSA3Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psa3);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_psa3);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Probability and Statistical Analysis");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.psa3_listView);
        initData();
        listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(listHash.get(listDataHeader.get(i)).get(i1).getmURL()));
                startActivity(intent);

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
        classMaterials.add(new DataURL("Probability","https://drive.google.com/open?id=1MgnLU-1fImVKrqxxMSAko7cNg_fc6Oiq"));
        classMaterials.add(new DataURL("Statistics","https://drive.google.com/open?id=1OnfJIswhexe3-yAleamRLtJW6wcotJaM"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Sanjay Probabilty","https://drive.google.com/open?id=1YhCXPWk7RH0l1iCNqqOiiHiXqkxR87Du"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1gprGZjIOn6wukuaYtW2PoLCz4LgIfyOP"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1B0FP1LqyIKJJW-0R7XZ_w-2mm31tbe-7"));
        examPapers.add(new DataURL("MidSem 19", "https://drive.google.com/open?id=1fwDFRID-vZBRV6tWJzytHcMPeKch0g8e"));
        examPapers.add(new DataURL("EndSem 19", "https://drive.google.com/open?id=1N1n-JUpIgqY_N-gmsT8MTOy85aSMyB-h"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }
}
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

public class NMUP5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nmup5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_nmup5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Numerical Methods Using Python");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.nmup5_listView);
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
        classMaterials.add(new DataURL("Decomposition","https://drive.google.com/open?id=1-o9H3JtIIptsl-a5-ki0IpTyiZzyPlR-"));
        classMaterials.add(new DataURL("Interpolation","https://drive.google.com/open?id=1XswvLAA7_2yJXrhEzY8L10L3h75z9AYi"));
        classMaterials.add(new DataURL("Newton's Method","https://drive.google.com/open?id=1M54mmp0s_UnleaavPZauka099_yyLrOW"));
        classMaterials.add(new DataURL("Numerical Integration","https://drive.google.com/open?id=1x0gJGt2MdDNv8n22Ju1Lbtwx4kDOu5uc"));
        classMaterials.add(new DataURL("Roots of Equation","https://drive.google.com/open?id=1LLaP9y0Ofp_Ib-MaVr6r_apjRXyh2ohj"));
        classMaterials.add(new DataURL("Spline Interpolation","https://drive.google.com/open?id=145apX-BFI7kAWp-osM-VLmEROSxv7gNB"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Numerical Methods In Engineering with Python","https://drive.google.com/open?id=19RQmWjZvNOsEM9ojC8051L1tOIiR2GUT"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=15xCrv4OOUwJeXZ2y4MYHQIYkEDP_Tqh0"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=1R5hRmwaoh7GWp7DCp1pFzYy3UJWIPi3e"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}

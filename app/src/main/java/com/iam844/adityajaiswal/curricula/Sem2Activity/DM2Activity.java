package com.iam844.adityajaiswal.curricula.Sem2Activity;

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

public class DM2Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dm2);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dm2);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Discrete Mathematics");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dm2_listView);
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
//        listDataHeader.add("Class Materials");
        listDataHeader.add("Books");
        listDataHeader.add("Exam Papers");

        //List
//        List<DataURL> classMaterials = new ArrayList<>();
//        classMaterials.add(new DataURL("",""));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Graphtheory - N Deo","https://drive.google.com/open?id=15rMtd78PCFvVyDrqv1cDKk5-mECEyxjl"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("Class Test 18", "https://drive.google.com/open?id=1iWcX5AeaFpFYMZoQhHiD_XC7el7xiSnA"));
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1YEmV8EBn_M9o-4QgO9iNATcvxILv4bW-"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1-wMWpH0yDPJ9dEu5hbpjFHtWhsLG7GEv"));


//        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(0), books);
        listHash.put(listDataHeader.get(1), examPapers);
    }

}

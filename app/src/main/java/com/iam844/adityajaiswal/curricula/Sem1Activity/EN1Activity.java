package com.iam844.adityajaiswal.curricula.Sem1Activity;

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

public class EN1Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en1);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_en1);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Electrical Networks");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.en1_listView);
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
        books.add(new DataURL("Electrical Technology - Theraja","https://drive.google.com/open?id=1wyeTHKs5K5zwE-UlKmPLz8vKYPuw9BKL"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 18", "https://drive.google.com/open?id=1o1xdjsAsFJF-8rBnva0i0B4z2PqxHwFi"));
        examPapers.add(new DataURL("EndSem 18", "https://drive.google.com/open?id=1qgTZ9T00sXxBh702D4zPp4M54ijVvmmc"));

//        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(0), books);
        listHash.put(listDataHeader.get(1), examPapers);
    }

}

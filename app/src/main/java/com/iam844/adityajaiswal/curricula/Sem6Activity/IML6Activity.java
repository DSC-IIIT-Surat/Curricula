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

public class IML6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iml6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_iml6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Introduction to Machine Learning");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.iml6_listView);
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
        listDataHeader.add("New Material");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("CART Example","https://drive.google.com/open?id=1dLJxQEzvaj2CKx_n02aj8ylulpoQhRtY"));
        classMaterials.add(new DataURL("Lecture 1","https://drive.google.com/open?id=1PYrk1EyVa7RWaTcIcvcZocv3Q1MURKZv"));
        classMaterials.add(new DataURL("Lecture 4","https://drive.google.com/open?id=17Z4PblZy3Ayp1iizGGCMctbJ30hhPK_H"));
        classMaterials.add(new DataURL("Lecture 4","https://drive.google.com/open?id=1M-Z45_cpht5Q1rl6Kg0xWiN_N6jeMdhR"));
        classMaterials.add(new DataURL("Lecture 6","https://drive.google.com/open?id=1wUjA3JjAd0WShgo7hHoAtZU4e7-bOxKW"));
        classMaterials.add(new DataURL("ML Decision Tree Learning","https://drive.google.com/open?id=1es2_IdIXmeBOuJUCWU8EM8Z5eZ9zcOsQ"));


        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Alppaydin Machine Learning","https://drive.google.com/open?id=1d_70O-enUtDiugZTvY8g8g-IPd_uQyXt"));
        books.add(new DataURL("Data Science From Scratch","https://drive.google.com/open?id=10AjyM-rjl5VmMQ2ZxwHRYRfkf8rwKTcS"));
        books.add(new DataURL("Machine Learning Tom-Mitchell","https://drive.google.com/open?id=1cVNY6FPL8ynsXxheucIoOvqCqcLwDH4b"));


        List<DataURL> newMaterial = new ArrayList<>();
        newMaterial.add(new DataURL("Clustering Algorithms K-means Clustering 1","https://drive.google.com/open?id=1pTu1niWK04E4u7u5wAHOGNR3hKL7XHl-"));
        newMaterial.add(new DataURL("Clustering Algorithms 2","https://drive.google.com/open?id=1QZsu1G2PXZxRVeRmjCW8Oyr0gd47J6PL"));
        newMaterial.add(new DataURL("Machine Leaning & Z-transform  NPTEL courses ","https://drive.google.com/open?id=1ya5NjYlM44V-PHMpGFEHcU_7aSo2kNeY"));
        newMaterial.add(new DataURL("NAIVE BAYES CLASSIFIER","https://drive.google.com/open?id=1oqYn1BNhK9oIgeEXjxF2lh-F1qOjIT5l"));
        newMaterial.add(new DataURL("Support Vector Machine (SVM)","https://drive.google.com/open?id=15qZbygL-_fZE8GTlB5I1KQ38ODizL9Zd"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), newMaterial);
    }
}

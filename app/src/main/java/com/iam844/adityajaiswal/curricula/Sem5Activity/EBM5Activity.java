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

public class EBM5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebm5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ebm5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Economic & Business Management");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ebm5_listView);
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
        classMaterials.add(new DataURL("Forms Of Business Organization ","https://drive.google.com/open?id=1MeGopuRN8AhbilFceqzYeZMKrWKnWf24"));
        classMaterials.add(new DataURL("Introduction to Management","https://drive.google.com/open?id=1oVUa-7GAqiwKgCOP_d0kQSA5qvXJidM_"));
        classMaterials.add(new DataURL("Development of Management Thoughts","https://drive.google.com/open?id=1Y242XpeEKnZrHewjDmqEVevxnz52Y06e"));
        classMaterials.add(new DataURL("Fundamentals of Planning","https://drive.google.com/open?id=1SvUoDuoTyjrpAZupw8AAPeFtP9290tR_"));
        classMaterials.add(new DataURL("Management by Objective","https://drive.google.com/open?id=1PuG81Pm8RIV2BcxFleHo1xdW_dYWABxU"));
        classMaterials.add(new DataURL("Types of Business Organization","https://drive.google.com/open?id=12KNP03UcAbxE1PJuKUErf5oJZdKIZ-_N"));
        classMaterials.add(new DataURL("Leadership","https://drive.google.com/open?id=1C_qA5AaY9PxekjS4YJsKsglYv1llQBku"));
        classMaterials.add(new DataURL("Motivation","https://drive.google.com/open?id=1qUV-LUluWejy0TDx0Q42JAU9qYYs1-Rt"));
        classMaterials.add(new DataURL("Demand Analysis","https://drive.google.com/open?id=1srlx-9yTOF7yhkIWzDaA9YXlhs8n-uBf"));
        classMaterials.add(new DataURL("Management,Planning,Motivation","https://drive.google.com/open?id=1cc7aql4_UQxJl0NpZOYXJS-5JWeg4s6G"));
        classMaterials.add(new DataURL("Personal Management","https://drive.google.com/open?id=1P_giA8ReW-eQOon8tl0GwVl77dDnd-qq"));
        classMaterials.add(new DataURL("Training & Development","https://drive.google.com/open?id=1kq4KyoKGqbG0sMmyqL7QzNBGX5Jp2UP-"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Principles & Practices of Management","https://drive.google.com/open?id=1jBME5jWDO8VSczYihCtmahLFT0nl8Mwe"));
        books.add(new DataURL("Industrial Engineering & Management","https://drive.google.com/open?id=1FDBC1NyqDh37L2KCvo-E9xjm5vVQ2Y7g"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1FoOnJDCeKdKwzpqtpZnC3IS-wFOTtOdQ"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=1nml8nvF3i1p_EPjVVzw2zzsIXUA3D5dV"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}

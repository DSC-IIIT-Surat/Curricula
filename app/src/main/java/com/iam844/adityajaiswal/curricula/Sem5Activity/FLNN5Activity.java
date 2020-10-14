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

public class FLNN5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flnn5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_flnn5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Fuzzy Logic & Neural Network");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.flnn5_listView);
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
        classMaterials.add(new DataURL("Amisha Mam MidSem Notes","https://drive.google.com/open?id=1DHAtO-edkdr_dH199hsPxF31qLGKd8wk"));
        classMaterials.add(new DataURL("Complete Learning","https://drive.google.com/open?id=1KqvJZbJAadHoUoMabGyoulINbBX5mxGh"));
        classMaterials.add(new DataURL("FNN EndSem Written Notes","https://drive.google.com/open?id=1W2Ha1Gojmudt4Vrn0XolF0TCLASuPp7k"));
        classMaterials.add(new DataURL("FNN MidSem","https://drive.google.com/open?id=1To2yd_3iBBolqvXBQPPGozfCHLQ6F6QX"));
        classMaterials.add(new DataURL("Fuzzy MidSem Written Notes","https://drive.google.com/open?id=1cVgwMLGc_KrSqBGhG_LjuyhSCFioLmoL"));
        classMaterials.add(new DataURL("Learning","https://drive.google.com/open?id=1zUsbXUIWHbPedmw7njyAAc6tKdAmrwOx"));
        classMaterials.add(new DataURL("Memory Based Learning","https://drive.google.com/open?id=18PWett7gSUi7y1DAACLwDaDNHZjoXL1v"));
        classMaterials.add(new DataURL("NN Written Notes","https://drive.google.com/open?id=1RPCncoPLPPS1vrzJFN1uTzQ4gsZMsf2l"));


        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Fuzzy Logic With Engineering Applications-TJ Ross 3rd Edition","https://drive.google.com/open?id=17w5YI3SOFQAmn9p6XpjDnlGsTz-7F0x1"));


        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1iKtEd35tqFHjq4kHUvFCyY3QyAZylUn4"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=17yjhFzwDsCsSqXO6CsMyMJV0ig8q9JuQ"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}

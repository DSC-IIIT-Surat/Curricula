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

public class AVR6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avr6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_avr6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Augmented & Virtual Reality");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.avr6_listView);
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
//        listDataHeader.add("New Material");
        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("VR Notes","https://drive.google.com/open?id=1MsQIBSaYe0-70Y-yqWxAASIqD5-tS-Wa"));
        classMaterials.add(new DataURL("Augmented and Virtual Reality","https://drive.google.com/open?id=1GlGWK99DE6qkuno2u-0id2w2-7WSIiux"));
        classMaterials.add(new DataURL("Light and Optics","https://drive.google.com/open?id=1TF1tZo_OjU86_XXANDg0iud1WNjvJRhf"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Virtual Reality ","https://drive.google.com/open?id=1OqZ9Jz5hMj4Y8MDWDVT1X_4oNsim9Cv7"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 2020", "https://drive.google.com/open?id=13OIdXnXBPUTkkWJwMUki-rmxU436x6-_"));
//        examPapers.add(new DataURL("EndSem 19"));

//        List<DataURL> newMaterial= new ArrayList<>();
        // examPapers.add(new DataURL("MidSem 2020", "https://drive.google.com/open?id=13OIdXnXBPUTkkWJwMUki-rmxU436x6-_"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
//        listHash.put(listDataHeader.get(3), newMaterial);
    }
}

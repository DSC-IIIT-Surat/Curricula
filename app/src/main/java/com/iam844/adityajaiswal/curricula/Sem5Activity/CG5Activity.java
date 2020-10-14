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

public class CG5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cg5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_cg5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Computer Graphics");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.cg5_listView);
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
//        listDataHeader.add("Exam Papers");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("3D Projections","https://drive.google.com/open?id=1iVQY6VYzvmjT13lJlv2ZISV6NI4R-XcS"));
        classMaterials.add(new DataURL("3D Clipping","https://drive.google.com/open?id=14504jl_dgKSxlaFR5GzliMSjf4_miqPq"));
        classMaterials.add(new DataURL("Basics of Computer Graphics","https://drive.google.com/open?id=1toa3bvwfcfqsLntts4k_HoNAItffhOQD3Gj3lJ0Uob0"));
        classMaterials.add(new DataURL("Graphic Primitives","https://drive.google.com/open?id=1G0rZekzHHirY_zwdXe250xuIaiSn2liCtXJCGuoT_Us"));
        classMaterials.add(new DataURL("2D Transformation & Viewing","https://drive.google.com/open?id=1P1dIzJqzhSecjm77bXhac7jX5HYpvDTqLhpwmPdb9YY"));
        classMaterials.add(new DataURL("Advance Topics","https://drive.google.com/open?id=1u8fGGs_YpO3Hl9PuVPPM7uSgK5VYZj5NifPSpOvwzB8"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Computer Graphics C Version","https://drive.google.com/open?id=1ryEC4iVy4PHmHddzC__JKlf-fn9_P8Vz"));

//        List<DataURL> examPapers = new ArrayList<>();
        // examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1C-6KFgICPsb9XQYI_rD_kR0e8UbUULJ8"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
//        listHash.put(listDataHeader.get(2), examPapers);
    }


}

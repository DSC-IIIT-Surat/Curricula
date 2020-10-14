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

public class SE5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_se5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Software Engineering");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.se5_listView);
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
        classMaterials.add(new DataURL("Agile Development","https://drive.google.com/open?id=14jH5SrXfCh0QxgTCjR9SCaKz26pA-VpmFhSkll0evv0"));
        classMaterials.add(new DataURL("Process Model","https://drive.google.com/open?id=1sWSCIgMHB6ZGZ6KnSP4kngr68vsiHTrHk6LNVqoAOLk"));
        classMaterials.add(new DataURL("SE Notes Final ","https://drive.google.com/open?id=14yEnJvYnOAFo-WQRob8s1MK8s5RNxeqS"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Fundamentals of Software Engineering","https://drive.google.com/open?id=18Ku9iKhzfSNKWhcbT8CRiA-WRlrGyCAR"));
        books.add(new DataURL("Software Engineering by Sommerville","https://drive.google.com/open?id=1_iGzorhEfd6ylV1lPo3hCWDyXV2TrO3y"));

//        List<DataURL> examPapers = new ArrayList<>();

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
//        listHash.put(listDataHeader.get(2), examPapers);
    }

}

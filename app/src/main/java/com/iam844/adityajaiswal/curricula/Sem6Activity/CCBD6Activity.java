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

public class CCBD6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ccbd6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_ccbd6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cloud Computing & Big Data Infrastructure");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.ccbd6_listView);
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
        listDataHeader.add("Practicals");
        listDataHeader.add(("New Material"));

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("HADOOP","https://drive.google.com/open?id=1X_SYV9-tlbjytdkiws8fbi1NZuO-W6zv"));
        classMaterials.add(new DataURL("Apache Pig","https://drive.google.com/open?id=1eF9yJTBltEUXxYcOShWDjsaoB40o58Xj"));
        classMaterials.add(new DataURL("MapReduce High-Level Languages","https://drive.google.com/open?id=1tMdOtLc3K5CMpJObX0L9LSdVPVMFGuve"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Mastering Cloud Computing","https://drive.google.com/open?id=1ibuVPkzxFc0edcBm91N6YD4CJn7qC6rn"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 2020", "https://drive.google.com/open?id=15ZGrcr56yZuE1WA8UWgg8nj7GI70yJbK"));
//        examPapers.add(new DataURL("EndSem 19"));

        List<DataURL> newMaterial = new ArrayList<>();
        newMaterial.add(new DataURL("Apache Hive","https://drive.google.com/open?id=1tipLWtpJSzyaDIMOrV2ActaFgE8_icxm"));

        List<DataURL> practical = new ArrayList<>();
        practical.add(new DataURL("Hadoop Framework Installation","https://drive.google.com/open?id=1KnL_VR2k7VRhdKlWCE1uqLfHZdWgBIF0"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3), practical);
        listHash.put(listDataHeader.get(4), newMaterial);
    }
}

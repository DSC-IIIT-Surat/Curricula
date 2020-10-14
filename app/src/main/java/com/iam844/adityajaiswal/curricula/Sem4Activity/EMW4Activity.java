package com.iam844.adityajaiswal.curricula.Sem4Activity;

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

public class EMW4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emw4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_emw4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Electromagnetic Waves");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.emw4_listView);
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

                    Toast.makeText(getApplicationContext(),
                            listDataHeader.get(i) + " : " + listHash.get(listDataHeader.get(i)).get(i1).getmName(),
                            Toast.LENGTH_SHORT).show();
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
        classMaterials.add(new DataURL("Notes 1 - Mid Sem","https://drive.google.com/open?id=1ovlJw3QE1UecIRt2Q3rYLvBBa_eFZt42"));
        classMaterials.add(new DataURL("Notes 2 - Mid Sem","https://drive.google.com/open?id=1W67wk9pkkLmrD0s7q3Uddvrc51S0A2la"));
        classMaterials.add(new DataURL("Antennas","https://drive.google.com/open?id=1Xwg3Ja5AbAgrpTzDAXX0emjWuxzfdsxv"));
        classMaterials.add(new DataURL("Antenna Problems","https://drive.google.com/open?id=1mf-qMpZTk58KfSpu5ot_RfCu8Z-_IQjB"));
        classMaterials.add(new DataURL("Waveguides","https://drive.google.com/open?id=1mfhlATqTqq22yP3VMm5KqWccvxWUH_Hk"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Poynting Theorem and Plane waves Propagation","https://drive.google.com/open?id=1K3DRHEMkSJ9bFm-dRCt2AY2_t5q2mtNL"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1vECSNJ3-jnYQrvPmTSf0TZtvZuZI-nWw"));
        examPapers.add(new DataURL("MidSem 20","https://drive.google.com/open?id=1y1NebAyVMigmJwtT5jkQe0SgGrxddi_F"));
//        examPapers.add(new DataURL("EndSem 19"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}
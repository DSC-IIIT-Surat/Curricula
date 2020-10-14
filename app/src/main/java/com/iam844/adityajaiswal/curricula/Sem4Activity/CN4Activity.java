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

public class CN4Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_cn4);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Computer Networks");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.cn4_listView);
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
        listDataHeader.add("New Material");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Introduction","https://drive.google.com/open?id=1H88rE3_RZyVfTBlME1pwP77zNhUSnfpO"));
        classMaterials.add(new DataURL("Network Models","https://drive.google.com/open?id=1ZqH1HZk1T0Eeet5ioTolI4zGLPt8QXME"));
        classMaterials.add(new DataURL("Error Detection and Correction","https://drive.google.com/open?id=1U_o-oSedmfeSzALJqFD17Wgakp9mdExL"));
        classMaterials.add(new DataURL("Data Link Control","https://drive.google.com/open?id=1FYahy9iDGtToPDpbmDMmIwuJqYWDr2zF"));
        classMaterials.add(new DataURL("Data Link Protocols","https://drive.google.com/open?id=1sNsm4UyHZqFVG4oEfw8aWJM-na25N_fJ"));
        classMaterials.add(new DataURL("Multiplexing","https://drive.google.com/open?id=1OwMnRk74T5D9AuH6sDs_gD4RCccbLxRS"));
        classMaterials.add(new DataURL("ARP and RARP","https://drive.google.com/open?id=1EJlb1Vlg-9G3J9zH_H-rKn_ybzWHJ2Ah"));
        classMaterials.add(new DataURL("ATM","https://drive.google.com/open?id=1Vch9gey_b5lyPfCgoCUxdsz_If6llXUw"));
        classMaterials.add(new DataURL("ICMP","https://drive.google.com/open?id=1t9FH-1rlRHeoAuIOiVUxB7R8H82P-lxg"));
        classMaterials.add(new DataURL("Logical Addressing","https://drive.google.com/open?id=1Lpl7RZRDfNMiCgDH12_foqq-FEz8N9aO"));
        classMaterials.add(new DataURL("Network Layer","https://drive.google.com/open?id=1sYtwZ2wjNfwy6u028mSc6wmN1tyA4_d_"));
        classMaterials.add(new DataURL("Switching","https://drive.google.com/open?id=1or_t9LuNGNkKCiO26VsaDBP8gWYySjkL"));
        classMaterials.add(new DataURL("Transition From IPv4 To IPv6","https://drive.google.com/open?id=1CaerM5NW8u2Azx8rvAL3GIEyfTKFNEHK"));
        classMaterials.add(new DataURL("Transmission Media","https://drive.google.com/open?id=1nM6EhKW87ROxm2oyHU-QRmJV6W23jlDD"));

        List<DataURL> newMaterial =new ArrayList<>();
        newMaterial.add(new DataURL("Transport-Layer","https://drive.google.com/open?id=1tWy7Xvufox24sDCYtnnZBbVMuFtf4hZD"));
        newMaterial.add(new DataURL("TransportL_services_TCP","https://drive.google.com/open?id=1TWyZooqUbbGRViNMElT_EwJVOii0QvN5"));
        newMaterial.add(new DataURL("Analog Transmission","https://drive.google.com/open?id=19s9ER75RJimxdFFNGLWnXvVZMxQOiJJT"));
        newMaterial.add(new DataURL("Physical Layer-Media ","https://drive.google.com/open?id=167YCj-V-HJs0sWinWCauWIObClHSnTD8"));
        newMaterial.add(new DataURL("Unit 2 Unguided Media","https://drive.google.com/open?id=1AabzJ-XlFo605VgHW5kWJmhLUCudU5MK"));

        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("Forouzan - Data Communication and Networking","https://drive.google.com/open?id=1UBA2D22PswgRah0sksP_H6kC-Uj1Fnp5"));
        books.add(new DataURL("Tanenbaum - Computer Networks","https://drive.google.com/open?id=1Ow6tapniqHV3DgZ8QgKnQbpb-zlbcacB"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19", "https://drive.google.com/open?id=1TtWHIbvPadx_FBZkKZesNK0KfpMaeFh1"));
        examPapers.add(new DataURL("MidSem 20","https://drive.google.com/open?id=1G_LVKsX0CdTYMi_YZ55Q7tiKp82dAmFT"));
//        examPapers.add(new DataURL("EndSem 19"));


        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
        listHash.put(listDataHeader.get(3),newMaterial);
    }
}
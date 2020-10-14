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

public class DIC5Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic5);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_dic5);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Digital Integrated Circuits");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.dic5_listView);
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
        classMaterials.add(new DataURL("ESE 570 MOS INVERTERS STATIC (DC Steady State) Characteristics","https://drive.google.com/open?id=1pFdFpxkjVToLidjxifkkqFrM8JB2ez_C"));
        classMaterials.add(new DataURL("EE 560 MOS INVERTERS: STATIC CHARACTERISTICS Kenneth R. Laker, University of Pennsylvania continued","https://drive.google.com/open?id=1g8z0BXqQNZcuWazNdfMsHdulFU6jQxDK"));
        classMaterials.add(new DataURL("EE 560 MOS Inverters : Dynamic Characteristics","https://drive.google.com/open?id=1tKq9Cy0lgZgBJyr7nKe1F-9ZTM2eRykw"));
//        classMaterials.add(new DataURL("DIC Darji Sir Written Notes EndSem 19",""));
//        classMaterials.add(new DataURL("DIC Darji Sir Written Notes MidSem 19",""));
//        classMaterials.add(new DataURL("Digital Integrated Circuits Gopal Sir",""));
        classMaterials.add(new DataURL("Logic Families Tutorial 1","https://drive.google.com/open?id=1qv5YrXyTImHqLeIatPuTTG4kaY_TbFyj"));
        classMaterials.add(new DataURL("Logic Families Tutorial 2","https://drive.google.com/open?id=15Y9eaDibhR0Jd9jVP8H8XXSwHUD3rjCZ"));
        classMaterials.add(new DataURL("Packaging","https://drive.google.com/open?id=1xaWcA1RF5-YwwT4-KfL6DeSXFtAS0JcZ"));


        List<DataURL> books = new ArrayList<>();
        books.add(new DataURL("CMOS kang","https://drive.google.com/open?id=1VEAUa53s_fEqHU0TgfgpHcKKR-Z9wzwr"));
        books.add(new DataURL("Digital Logic and Computer Design M. Morris Mano","https://drive.google.com/open?id=1zangkWzzawfk_uV-aBWrUJ3FlxboZrdR"));
        books.add(new DataURL("Microelectronic Circuits ","https://drive.google.com/open?id=1vOm_--hyxE1d_vA22kd5E2Xy0qiDvGoX"));
        books.add(new DataURL("Microelectronics Circuit Analysis and Design 4th Edition","https://drive.google.com/open?id=1BqvZRO0FVqcMOyVTXEnTBCS2EL0mntDv"));
        books.add(new DataURL("Solution - Microelectronics Circuit Analysis and Design Donal 4th Edition","https://drive.google.com/open?id=1fPJeuIUjzGQ2R2fMbsXYBa5faxhO-gmY"));

        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 19","https://drive.google.com/open?id=1SbBatIXKxnnAUHJ8nepj4zErJ7hpQUGL"));
        examPapers.add(new DataURL("EndSem 19","https://drive.google.com/open?id=1VvKJLlHGGmtCpN0q_ooTWgaUqD0Jbdes"));



        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), books);
        listHash.put(listDataHeader.get(2), examPapers);
    }

}

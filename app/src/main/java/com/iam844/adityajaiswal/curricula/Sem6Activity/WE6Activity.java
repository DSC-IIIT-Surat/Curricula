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

public class WE6Activity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we6);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_activity_we6);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Web Engineering");
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.we6_listView);
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
        listDataHeader.add("Exam Papers");
        listDataHeader.add("New Materials");

        //List
        List<DataURL> classMaterials = new ArrayList<>();
        classMaterials.add(new DataURL("Lec 01 Introduction","https://drive.google.com/open?id=1hQ2nGU0NGqWf_PyRMhBzB7tdrS8XVL1b"));
        classMaterials.add(new DataURL("Lec 02 HTML-1","https://drive.google.com/open?id=1dwtD3BuGL30TejEtElo3JADUBKssxDRm"));
        classMaterials.add(new DataURL("Lec 03 HTML-2","https://drive.google.com/open?id=13IOuCF-NC9pF4Ke8XxV5TmlCnaQx60Aj"));
        classMaterials.add(new DataURL("Lec 04 HTML-3","https://drive.google.com/open?id=1cn8hVIGazl_vO_4WSXl5TZZVGoglZs9J"));
        classMaterials.add(new DataURL("Lec 05 CSS","https://drive.google.com/open?id=10b2PvlYqHzkgCOagoJIYxtgu-tVD73Iu"));
        classMaterials.add(new DataURL("Lec 06 Bootstrap","https://drive.google.com/open?id=1IOeDGAK9F1CTOxl_2btszHQBVTXlrOk1"));
        classMaterials.add(new DataURL("Lec 07 Javascript","https://drive.google.com/open?id=1etgYQmxq_gTe1LGKPAKNOXKHSO3UvdgV"));
        classMaterials.add(new DataURL("Lec 08 JQuuery & AJAX","https://drive.google.com/open?id=1wOMywPe7xqF3Ie2dmNlIMahbDlp9LQH7"));
        classMaterials.add(new DataURL("Lec 09 PHP-1","https://drive.google.com/open?id=1P-kV8ZN44e2kCxA_X32FspGcLv_vZQkt"));
        classMaterials.add(new DataURL("Lec 10 PHP-2","https://drive.google.com/open?id=1x_wWEftjRnR90BBci6uckZACOZe_Z8w8"));
        classMaterials.add(new DataURL("Lec 11 PHP-3","https://drive.google.com/open?id=1Q_CIz8me5K2HE_VQNNvXbeQFOvbQMtLc"));
        classMaterials.add(new DataURL("Lec 12 PHP-4","https://drive.google.com/open?id=1YWGoy3f-_zSWry5PEXKWkuoOI1q4iOqb"));
        classMaterials.add(new DataURL("Lec 13 PHP-5","https://drive.google.com/open?id=1VMnv5V1llIs7DmJfbE6SBc2y_P0RnaZs"));
        classMaterials.add(new DataURL("Lec 14 Laravel-1 Installation","https://drive.google.com/open?id=1ezo4SAybXr_JzfHZvz4rX2bUH1sBS7iQ"));
        classMaterials.add(new DataURL("Lec 15 Laravel-2 Routes & Controllers","https://drive.google.com/open?id=1vd-jP4na9_QN-cPJa72Be8-olvxmkwVQ"));
        classMaterials.add(new DataURL("Lec 16 Laravel-3 Views & BladeTemplating","https://drive.google.com/open?id=1mKaySm8oYHdONn2aNznb0eeEPPTSTt-Y"));
        classMaterials.add(new DataURL("Lec 17 Laravel-4 Model,Migrations,Seeding","https://drive.google.com/open?id=1AKlfBKdWYLFNjRAU8ijmbqQ0b7tu6QZ8"));
        classMaterials.add(new DataURL("Lec 18 Laravel-5 CRUD Opeations with Laravel","https://drive.google.com/open?id=1sCHmUvOVjd_KJTW7vv3DA-VdZj4p0vRM"));
        classMaterials.add(new DataURL("CH1","https://drive.google.com/open?id=1Dgwg_yxHMDo6QdBoerzLWCvPbfFAIV2j"));
        classMaterials.add(new DataURL("CH2","https://drive.google.com/open?id=1VAUOrPgMZFtmzOVqlrCEW1HB9dLAuFw1"));
        classMaterials.add(new DataURL("CH3","https://drive.google.com/open?id=1nJLFAe4tgm5WE-HpWTEvOaGvxROrEqyV"));
        classMaterials.add(new DataURL("CH4","https://drive.google.com/open?id=1lKNlR8mXq5ZAu6Xb4l6uC7U6dW4mZKkn"));
        classMaterials.add(new DataURL("CH5","https://drive.google.com/open?id=1kH9fxf931u4Bv_mqpfNPecYNoQDy3AIz"));
        classMaterials.add(new DataURL("CH6","https://drive.google.com/open?id=1tg_UKrIQ2emYBX9AAsiaQA71FIV8rqJm"));
        classMaterials.add(new DataURL("CH7","https://drive.google.com/open?id=1JorgTVFQFmWi6W0LNQAIGsocvZdivXAh"));
        classMaterials.add(new DataURL("CH8","https://drive.google.com/open?id=10Jf056Juk67ZYH8BB_l_RXuAmQjoNIlY"));
        classMaterials.add(new DataURL("CH9","https://drive.google.com/open?id=1LTXSUxTHlvACKgZvmlCgAA8ipe3pxviC"));
        classMaterials.add(new DataURL("CH10","https://drive.google.com/open?id=1QrzNVRG6dx48hc7NUE5bo7BnHl6OzaDT"));
        classMaterials.add(new DataURL("CH11","https://drive.google.com/open?id=1sgH9UmMjcnPJRdZBkuzH6WS3YoQ0ypbt"));
        classMaterials.add(new DataURL("CH12","https://drive.google.com/open?id=1ZQ-9PeJQ-SM99Xo3YHXM7fuuelbYdo6k"));
        classMaterials.add(new DataURL("CH15","https://drive.google.com/open?id=1_zzBKQNLR5ysnNCpfuTxlo0dlUQvgG94"));


        List<DataURL> examPapers = new ArrayList<>();
        examPapers.add(new DataURL("MidSem 2020", "https://drive.google.com/open?id=15U_QaFOVPkr80bMeoXvyzdlUEcabat38"));
//        examPapers.add(new DataURL("EndSem 19"));

        List<DataURL> newMaterial = new ArrayList<>();
        newMaterial.add(new DataURL("Lec 19 Web services-1","https://drive.google.com/open?id=19vJWHotGFndGfG0v_B16iKUIANvUxtLc"));
        newMaterial.add(new DataURL("Lec 20 Web services-2","https://drive.google.com/open?id=1-SrWuHUDvxwQZCLENX5Q7XJiLEuRyO7r"));

        listHash.put(listDataHeader.get(0), classMaterials);
        listHash.put(listDataHeader.get(1), examPapers);
        listHash.put(listDataHeader.get(2), newMaterial);
    }
}

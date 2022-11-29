package com.iam844.adityajaiswal.curricula;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.iam844.adityajaiswal.curricula.Adapter.MaterialExpandableListAdapter;
import com.iam844.adityajaiswal.curricula.Model.DataURL;

import org.json.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubjectContentActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<DataURL>> listHash;

    private List<DataURL> examPapers, books;
    private String subjectCode;
    private String semesterCode;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_content);

        listView = findViewById(R.id.subject_listView);
        toolbar = findViewById(R.id.toolbar_activity_subject);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        subjectCode = i.getExtras().getString("subjectCode");
        semesterCode = i.getExtras().getString("semesterCode");

        JSONObject data = readFile();
        initData(data);
        setData(data);


        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                if (listHash.get(listDataHeader.get(i)).get(i1).getmURL() == null) {
                    Toast.makeText(getApplicationContext(), "Will be updated soon!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(listHash.get(listDataHeader.get(i)).get(i1).getmURL()));
                    startActivity(intent);
                }

                return false;
            }
        });

    }

    public void setData(JSONObject data) {


        try {
            ActionBar actionBar = getSupportActionBar();
            actionBar.setTitle(data.getString("name"));
            actionBar.setDisplayHomeAsUpEnabled(true);

            listAdapter = new MaterialExpandableListAdapter(this, listDataHeader, listHash);
            listView.setAdapter(listAdapter);

        } catch (JSONException e) {
            System.out.println(e);
        }
    }

    public JSONObject readFile() {
        InputStream is = getResources().openRawResource(R.raw.data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = writer.toString();


        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONArray allSubjects = obj.getJSONObject("semester").getJSONArray(semesterCode);
            JSONObject sub = new JSONObject();

            for (int i = 0; i < allSubjects.length(); i++) {

                if (allSubjects.getJSONObject(i).getString("code").equals(subjectCode)) {
                    sub = allSubjects.getJSONObject(i);
                    break;
                }
            }

            return sub;
        } catch (JSONException e) {
            System.out.println(e.toString());
        }

        return null;
    }

    public void initData(JSONObject data) {
        listDataHeader = new ArrayList<>();     //Group list
        listHash = new HashMap<>();             //Child List

        List<DataURL> classMaterials = new ArrayList<>();
        List<DataURL> books = new ArrayList<>();

        try {
            if (data.has("class_materials"))
                if (data.getJSONArray("class_materials").length() != 0) {
                    listDataHeader.add("Class Materials");
                    JSONArray tempArray = data.getJSONArray("class_materials");

                    for (int i = 0; i < tempArray.length(); i++) {
                        JSONObject temp = tempArray.getJSONObject(i);
                        classMaterials.add(new DataURL(temp.getString("name"), temp.getString("url")));
                    }

                    listHash.put("Class Materials", classMaterials);
                }


            if (data.has("books"))
                if (data.getJSONArray("books").length() != 0) {
                    listDataHeader.add("Books");
                    JSONArray tempArray = data.getJSONArray("books");

                    for (int i = 0; i < tempArray.length(); i++) {
                        JSONObject temp = tempArray.getJSONObject(i);
                        books.add(new DataURL(temp.getString("name"), temp.getString("url")));
                    }
                    listHash.put("Books", books);
                }

        } catch (JSONException e) {
            System.out.println(e.toString());
        }
    }

}
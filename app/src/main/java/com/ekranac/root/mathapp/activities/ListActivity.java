package com.ekranac.root.mathapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ekranac.root.mathapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Removes title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);

        // Raw data
        String[] forecastArray =
                {
                        "Razdalja dveh točk v ravnini",
                        "Linearna funkcija",
                        "Naklonski kot premice",
                        "Smerni koeficient",
                        "Kot med premicama",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek",
                        "Burek"
                };

        // Transforms raw data from Array to ArrayList so it can be implemented to adapter later
        List<String> arrayList = new ArrayList<String>(Arrays.asList(forecastArray));



        // Adapter set
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(
                // Get context of the activity
                getApplicationContext(),
                // List item layout
                R.layout.list_item,
                // ID of the TextView to populate
                R.id.list_item_textview,
                // ArrayList data
                arrayList
        );


        ListView listView = (ListView) findViewById(R.id.listview_main);
        listView.setAdapter(mAdapter);
        
        
        // Bullshit onClick stuff

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Log.i("Burek", "Jep");
            }
        });
    }
}

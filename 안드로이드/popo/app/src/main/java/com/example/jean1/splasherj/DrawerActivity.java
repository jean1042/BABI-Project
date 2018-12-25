package com.example.jean1.splasherj;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class DrawerActivity extends Activity {
    private String[] items={"FEED","EXPLORE","MESSAGES","NOTIFICATIONS","PHOTOS","SETTINGS","SEARCH"};
    private ListView list;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

    frame=(FrameLayout)findViewById(R.id.frame);
    list=(ListView)findViewById(R.id.list);

    list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items));

    }
}

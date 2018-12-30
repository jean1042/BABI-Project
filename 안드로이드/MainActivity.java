package com.example.jean1.splasherj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.jean1.splasherj.R;
import com.github.mikephil.charting.charts.PieChart;

public class MainActivity extends AppCompatActivity {

    private String[] items={"MAIN","EXPLORE","MESSAGES","NOTIFICATIONS","PHOTOS","SETTINGS","SEARCH"};
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView)findViewById(R.id.list);

        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items));

        setCustomActionbar();
    }



   public void modifyClick(View v){
       final PopupWindow popupwindowmodify;

       //activity_calendar.xml inflating
       Context mContext = getApplicationContext();
       LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View layoutview = inflater.from(this).inflate(R.layout.activity_modify, null);

       //create the popupwindow
       popupwindowmodify = new PopupWindow(layoutview, 800, 1000, true);
       popupwindowmodify.setContentView(layoutview);
       popupwindowmodify.showAtLocation(layoutview, Gravity.CENTER, 0, 0);

       Button btn_modify = (Button) layoutview.findViewById(R.id.btn_edit_modify);
       Button btn_cancel = (Button) layoutview.findViewById(R.id.btn_edit_cancel);

        btn_modify.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(MainActivity.this, EditActivity.class);
               startActivity(intent);
           }
       });
       btn_cancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               popupwindowmodify.dismiss();

           }
       });



   }

    //actionbar
    private  void setCustomActionbar(){
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        //actionBar.setDisplayShowHomeEnabled(false);

        //set custom view layout
        View actionbar =  LayoutInflater.from(this).inflate(R.layout.custom_actionbar,null);

        actionBar.setCustomView(actionbar);




        android.support.v7.widget.Toolbar parent;
        parent = (android.support.v7.widget.Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(actionbar, params);
    }

    //포부의 질문 버튼
    public void btnPoboo(View v){
        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        startActivity(intent);
    }


    //차트버튼
    public void btnChart(View v){
        Intent intent = new Intent(MainActivity.this, ChartActivity.class);
        startActivity(intent);
    }

    public void btnMain(View v){
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

}


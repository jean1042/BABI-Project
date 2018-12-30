package com.example.jean1.splasherj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity{

    PieChart pieChart;
    View layoutview;
    Button btn_chart;

    private String[] items={"FEED","EXPLORE","MESSAGES","NOTIFICATIONS","PHOTOS","SETTINGS","SEARCH"};
    private ListView list;
    //private FrameLayout frame;
    private com.github.mikephil.charting.charts.PieChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


        chart=(com.github.mikephil.charting.charts.PieChart)findViewById(R.id.piechart);
        list=(ListView)findViewById(R.id.list);

        list.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items));

        //btn_chart =(Button)findViewById(R.id.btn_Chart);
        //Log.e("tt", "tt1");
//        btn_chart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e("tt", "tt2");
//
//            }
//        });

/*
        Context mContext=getApplicationContext();
        Log.e("tt" , "tt1");
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutview=inflater.from(this).inflate(R.layout.custom_actionbar,null);
        final LinearLayout chartLinear=(LinearLayout)findViewById(R.id.chartLinear);
        final Button btn_chart =(Button)layoutview.findViewById(R.id.btnChart);

        chartLinear.addView(layoutview);
        Log.e("tt" , "tt1");



        Button btn_poboo = (Button)layoutview.findViewById(R.id.btnPoboo);



        btn_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View layoutview) {
                Log.e("tt" , "tt7");
                Toast.makeText(ChartActivity.this,"item clicked",Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ChartActivity.this, LoginActivity.class);
                //startActivity(intent);
            }
        });
*/


        setCustomActionbar();

        pieChart = (PieChart)findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 0, 5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setEntryLabelColor(Color.WHITE);
        pieChart.setDrawHoleEnabled(false);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(40f);

        ArrayList<PieEntry> yValues = new ArrayList<PieEntry>();

        yValues.add(new PieEntry(15f,"In Campus"));
        yValues.add(new PieEntry(19f,"Out Campus"));
        yValues.add(new PieEntry(30f,"학업"));
        yValues.add(new PieEntry(28f,"개인 프로젝트"));
        yValues.add(new PieEntry(23f,"커리어"));


        pieChart.animateY(1000, Easing.EasingOption.EaseInOutCubic);    //애니메이션

        PieDataSet dataSet = new PieDataSet(yValues,"");
        dataSet.setSelectionShift(5f);

        //legends
        int colorWhite = Color.parseColor("#ffffff");
        pieChart.getLegend().setTextColor(colorWhite);
        pieChart.getLegend().setTextSize(14f);
        pieChart.getLegend().setFormSize(14f);
        pieChart.getLegend().setYOffset(50f);
        pieChart.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);


        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(170,134,182));
        colors.add(Color.rgb(192,181,206));
        colors.add(Color.rgb(174,171,206));
        colors.add(Color.rgb(146,144,201));
        colors.add(Color.rgb(127,114,165));

        dataSet.setColors(colors);

        PieData data = new PieData((dataSet));
        data.setValueTextSize(15f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);

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

    //마이페이지 버튼
    public void btnPoboo(View v){
        Intent intent = new Intent(ChartActivity.this, QuestionActivity.class);
        startActivity(intent);
    }


    //차트버튼
    public void btnChart(View v){
        Intent intent = new Intent(ChartActivity.this, ChartActivity.class);
        startActivity(intent);
    }


    public void btnMain(View v){
        Intent intent = new Intent(ChartActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

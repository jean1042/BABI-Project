package com.example.jean1.splasherj;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

public class QuestionActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setCustomActionbar();
    }

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
        Intent intent = new Intent(QuestionActivity.this, QuestionActivity.class);
        startActivity(intent);
    }


    //차트버튼
    public void btnChart(View v){
        Intent intent = new Intent(QuestionActivity.this, ChartActivity.class);
        startActivity(intent);
    }

    public void btnMain(View v){
        Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

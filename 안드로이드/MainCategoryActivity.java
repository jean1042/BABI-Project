package com.example.jean1.splasherj;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainCategoryActivity extends AppCompatActivity {
    private  ViewPager viewPager;
    private  Button btn_choice_category; //선택완료버튼
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_category);

        hideActionBar();

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        btn_choice_category = (Button)findViewById(R.id.btn_choice_category) ;

        //어댑터
        viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(0);

        //선택완료버튼 클릭 리스너
        btn_choice_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainCategoryActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });

        /* 추후 화살표 버튼 기능 추가 + 소분류로 액티비티 이동*/
        // btn_left.setOnClickListener(new View.OnClickListener(){
        //   public  void onclick(View v){
        //     int curr = viewPager.getCurrentItem();  //현재 번호
        //   int lastItem =
        //}
        //});
        //btn_right.setOnClickListener();


    }



    private class pagerAdapter extends FragmentStatePagerAdapter{
        public pagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);
        }
        public  android.support.v4.app.Fragment getItem(int position){
            switch (position)
            {
                case 0:
                    return  new IncamFragment();
                case 1:
                    return new OutcamFragment();
                case 2:
                    return new CareerFragment();
                case 3:
                    return new ProjectFragment();
                case 4:
                    return new StudyFragment();
                default:
                    return null;
            }
        }
        public int getCount(){
            return 5;
        }

    }
    public void hideActionBar(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }


}

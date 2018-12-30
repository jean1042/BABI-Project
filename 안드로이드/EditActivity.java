package com.example.jean1.splasherj;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity{


    //layout view 변수
    EditText activity_name;
    TextView period_1;
    TextView period_2;
    EditText activity_content;
    Button btn_save;

    //활동명, 활동설명 변수
    String str_activity_name;
    String str_activity_content;

    //활동시작일, 활동마침일 변수
    String str_start_year;
    String str_start_month;
    String str_start_day;
    String str_final_year;
    String str_final_month;
    String str_final_day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


//        //파이어베이스 변수 할당
//        database=FirebaseDatabase.getInstance();
//        id=database.getReference("id");
//        Log.e("tt", "useid:"+id);

        //전역변수 저장을 위한 클래스 가져오기
        final CommonData mydata = (CommonData) getApplication();


        btn_save = (Button) findViewById(R.id.btn_save);
        activity_name = (EditText) findViewById(R.id.edit_title);
        period_1 = (TextView) findViewById(R.id.edit_period1);
        period_2 = (TextView) findViewById(R.id.edit_period2);
        activity_content = (EditText) findViewById(R.id.edit_content);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_activity_name = activity_name.getText().toString();
                str_activity_content = activity_content.getText().toString();

                //전역변수 설정
                mydata.setData(str_activity_name);
                mydata.setData(str_activity_content);

                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        hideActionBar();

    }
    public void hideActionBar(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }
    //활동시작기간 입력받기
    public void mOnPopupClick(View v) {

        final PopupWindow popupwindow1;

        //activity_calendar.xml inflating
        Context mContext = getApplicationContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutview = inflater.from(this).inflate(R.layout.activity_calendar, null);

        //create the popupwindow
        popupwindow1 = new PopupWindow(layoutview, 800, 1000, true);
        popupwindow1.setContentView(layoutview);
        popupwindow1.showAtLocation(layoutview, Gravity.CENTER, 0, 0);

        CalendarView cv = (CalendarView) layoutview.findViewById(R.id.calendar);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // popupwindow1.dismiss();

                str_start_year = String.valueOf(year);
                str_start_month = String.valueOf(month + 1);
                str_start_day = String.valueOf(dayOfMonth);

                Log.e("tt year", str_start_year + "/" + str_start_month + "/" + str_start_day);

            }
        });

        Button btn_submit = (Button) layoutview.findViewById(R.id.btn_submit);
        Button btn_cancel = (Button) layoutview.findViewById(R.id.btn_cancel);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow1.dismiss();
                period_1.setText(str_start_year + "." + str_start_month + "." + str_start_day);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow1.dismiss();
                period_1.setText(str_start_year + "." + str_start_month + "." + str_start_day);
            }
        });

    }

    //활동종료기간 입력받기
    public void mOnPopupClick2(View v) {
        final PopupWindow popupwindow1;

        //activity_calendar.xml inflating
        Context mContext = getApplicationContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutview = inflater.from(this).inflate(R.layout.activity_calendar, null);

        //create the popupwindow
        popupwindow1 = new PopupWindow(layoutview, 800, 1100, true);
        popupwindow1.setContentView(layoutview);
        popupwindow1.showAtLocation(layoutview, Gravity.CENTER, 50, 50);

        CalendarView cv = (CalendarView) layoutview.findViewById(R.id.calendar);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // popupwindow1.dismiss();

                str_final_year = String.valueOf(year);
                str_final_month = String.valueOf(month + 1);
                str_final_day = String.valueOf(dayOfMonth);

                Log.e("tt year", str_final_year + "/" + str_final_month + "/" + str_final_day);

            }
        });

        Button btn_submit = (Button) layoutview.findViewById(R.id.btn_submit);
        Button btn_cancel = (Button) layoutview.findViewById(R.id.btn_cancel);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow1.dismiss();
                period_2.setText(str_final_year + "." + str_final_month + "." + str_final_day);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow1.dismiss();
                period_1.setText(str_start_year + "." + str_start_month + "." + str_start_day);
                //  savetoDatabase();
            }
        });

    }

public void toEdit(View v){
    Intent intent = new Intent(EditActivity.this, InsertActivity.class);
    startActivity(intent);
}


}

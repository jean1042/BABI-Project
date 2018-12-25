
package com.example.jean1.splasherj;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.jean1.splasherj.R;

public class ModifyActivity extends AppCompatActivity {
    View layoutview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        hideActionBar();

    }
        //활동기록 수정하기
    public void modifyClick(View v) {

        final PopupWindow popupwindow1;
        final PopupWindow[] popupwindow2 = new PopupWindow[1];

        //activity_calendar.xml inflating
        Context mContext = getApplicationContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutview = inflater.from(this).inflate(R.layout.activity_modify, null);


        //create the popupwindow
        popupwindow1 = new PopupWindow(layoutview, 800, 1000, true);
        popupwindow1.setContentView(layoutview);
        popupwindow1.showAtLocation(layoutview, Gravity.CENTER, 0, 0);
    }

    public void hideActionBar(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }
}

/*
        TextView edit_modify_name = (TextView) layoutview.findViewById(R.id.txt_modify_name);
        TextView edit_modify_content = (TextView) layoutview.findViewById(R.id.txt_modify_content);
        TextView edit_modify_location = (EditText) layoutview.findViewById(R.id.txt_modify_location);
        Button btn_edit_modify = (Button) layoutview.findViewById(R.id.btn_edit_submit);
        Button btn_edit_cancel = (Button) layoutview.findViewById(R.id.btn_edit_cancel);

        TextView txt_modify_period1=(TextView)layoutview.findViewById(R.id.txt_modify_period1);
        TextView txt_modify_period2=(TextView)layoutview.findViewById(R.id.txt_modify_period2);

        //수정 완료 버튼 클릭 리스너
        btn_edit_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifyActivity.this, EditActivity.class);
                startActivity(intent);
            }
        });

        //수정 취소 버튼 클릭 리스너
        btn_edit_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupwindow1.dismiss();
            }
        });


    }
}
*/
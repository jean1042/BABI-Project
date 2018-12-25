package com.example.jean1.splasherj;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;

public class YearpickerActivity extends AppCompatActivity {
    Button okBtn;
    NumberPicker np;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_yearpicker);

        hideActionBar();

        np = (NumberPicker)findViewById(R.id.numberPicker);
        np.setMinValue(2000);
        np.setMaxValue(2099);
        np.setValue(2018);
        np.setWrapSelectorWheel(false);
        okBtn = (Button)findViewById(R.id.btn_ok);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YearpickerActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void hideActionBar(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }


}

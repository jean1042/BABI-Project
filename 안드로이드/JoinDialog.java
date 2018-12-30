package com.example.jean1.splasherj;


import android.content.Intent;
import android.content.res.Resources;
import android.os.PatternMatcher;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.TextureView;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean1.splasherj.R;

import java.util.regex.Pattern;

public class JoinDialog extends AppCompatActivity {
    EditText email;
    EditText pw;
    EditText pwConfirm;
    EditText year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        email = (EditText) findViewById(R.id.emailText);
        pw = (EditText) findViewById(R.id.pwText);
        pwConfirm = (EditText) findViewById(R.id.pwConfirmText);
        year = (EditText)findViewById(R.id.yearText);
    }

    public void eAuthClick(View v){ //이메일인증 버튼 눌렀을 경우
        check();
    }
    //입력값 검사
    public void check() {

        email = (EditText) findViewById(R.id.emailText);
        pw = (EditText) findViewById(R.id.pwText);
        pwConfirm = (EditText)findViewById(R.id.pwConfirmText);
        year = (EditText)findViewById(R.id.yearText);

        String idCheck = email.getText().toString();
        String pwCheck = pw.getText().toString();
        String pwConfirmChek = pwConfirm.getText().toString();
        String yaerCheck = year.getText().toString();

        if (TextUtils.isEmpty(idCheck)) { //이메일 빈칸 검사
            email.setError("이메일을 입력해주세요");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(idCheck).matches()) { //이메일 형식 검사
            email.setError("올바른 이메일 형식이 아닙니다.");
            email.setText(null);
            return;
        }

        if (TextUtils.isEmpty(pwCheck)) { //비밀번호 빈칸 검사
            pw.setError("비밀번호를 입력해주세요");
            return;
        }

        if (!Pattern.matches("^[A-Za-z0-9_@./#&+-]*.{5,20}$", pwCheck)) {
            pw.setError("올바른 비밀번호 형식이 아닙니다.");
            pw.setText(null);
            return;
        }

        if(TextUtils.isEmpty(pwConfirmChek)){ //비밀번호 확인 빈칸 검사
            pwConfirm.setError("비밀번호 확인을 입력해주세요");
            pwConfirm.setText(null);
            return;
        }

        if(!pwCheck.equals(pwConfirmChek)){   //비밀번호와 비밀번호 확인 동일여부 검사
            pwConfirm.setError("비밀번호가 일치하지 않습니다.");
            pwConfirm.setText(null);
            return;
        }

        if(TextUtils.isEmpty(pwConfirmChek)){ //비밀번호 확인 빈칸 검사
            pwConfirm.setError("비밀번호 확인을 입력해주세요");
            pwConfirm.setText(null);
            return;
        }

        if(TextUtils.isEmpty(yaerCheck)){
            year.setError("학번을 입력해주세요");
            return;
        }

    }
}

package com.example.jean1.splasherj;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText id ;
    EditText pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id = (EditText)findViewById(R.id.emailText);
        pw = (EditText)findViewById(R.id.pwText);

        hideActionBar();
    }

    public void loginClick(View v){ //로그인버튼 클릭
        check();

        Intent intent = new Intent(LoginActivity.this, PlusActivity.class);
        startActivity(intent);

    }
    public void joinClick(View v){ //회원가입버튼 클릭
        Intent intent = new Intent(LoginActivity.this, JoinDialog.class);
        startActivity(intent);
    }
    ////입력값 검사
    public void check(){

        id = (EditText) findViewById(R.id.emailText);
        pw = (EditText) findViewById(R.id.pwText);
        String idCheck = id.getText().toString();
        String pwCheck = pw.getText().toString();

        if(TextUtils.isEmpty(idCheck)){ //이메일 빈칸 검사
            id.setError("이메일을 입력해주세요");
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(idCheck).matches()){ //이메일 형식 검사
            id.setError("올바른 이메일 형식이 아닙니다.");
            id.setText(null);
            return;
        }

        if(TextUtils.isEmpty(pwCheck)){ //비밀번호 빈칸 검사
            pw.setError("비밀번호를 입력해주세요");
            return;
        }

        if (!Pattern.matches("^[A-Za-z0-9_@./#&+-]*.{5,20}$", pwCheck)) {
            pw.setError("올바른 비밀번호 형식이 아닙니다.");
            pw.setText(null);
            return;
        }
    }
    public void hideActionBar(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
    }

}
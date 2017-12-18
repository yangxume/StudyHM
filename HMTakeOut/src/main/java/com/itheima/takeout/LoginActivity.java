package com.itheima.takeout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itheima.takeout.dagger.componet.activity.DaggerLoginActivityComponet;
import com.itheima.takeout.dagger.componet.activity.LoginActivityComponet;
import com.itheima.takeout.dagger.module.activity.LoginActivityModule;
import com.itheima.takeout.presenter.LoginActivityPresenter;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_username;
    private EditText et_pawword;
    private Button btn_login;

    @Inject
    LoginActivityPresenter loginActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        LoginActivityComponet componet = DaggerLoginActivityComponet.builder()
                .loginActivityModule(new LoginActivityModule(LoginActivity.this))
                .build();

        componet.in(LoginActivity.this);

    }

    private void initViews() {

        et_username = (EditText) findViewById(R.id.et_username);
        et_pawword = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_login:

                login();

                break;


        }

    }

    private void login() {


        String username = et_username.getText().toString();
        String password = et_pawword.getText().toString();

        boolean checkUserInfo = checkUserInfo(username, password);

        if (checkUserInfo){

            loginActivityPresenter.login(username,password);

            ProgressDialog dialog = new ProgressDialog(this);
            dialog.show();

        }else {
            Toast.makeText(LoginActivity.this,"登录失败!",Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkUserInfo(String username, String password) {

        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            return true;
        }

        return false;
    }

    public void loginSuccess() {

    }

    public void loginFailed() {

    }
}

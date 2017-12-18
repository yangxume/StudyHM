package com.itheima.takeout.presenter;

import android.widget.Toast;

import com.itheima.takeout.LoginActivity;
import com.itheima.takeout.model.Constant;
import com.itheima.takeout.model.ResponseInfo;
import com.itheima.takeout.model.net.ResponseInfoApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Copyright (C), 2017
 * @FileName
 * @Author yang.xu
 * @email xuyangme@126.com
 * @Version
 * @Date 2017/11/25
 * @Description:
 */

public class LoginActivityPresenter {

    private LoginActivity loginActivity;

    public LoginActivityPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    /**
     * 登录的业务逻辑
     * @param username
     * @param password
     */
    public void login(String username,String password){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ResponseInfoApi responseInfoApi = retrofit.create(ResponseInfoApi.class);

        final Call<ResponseInfo> login = responseInfoApi.login(username, password);
        login.enqueue(new Callback<ResponseInfo>() {
            @Override
            public void onResponse(Call<ResponseInfo> call, Response<ResponseInfo> response) {

                ResponseInfo body = response.body();
                if ("0".equals(body.code)){

                    loginActivity.loginSuccess();

                }

            }

            @Override
            public void onFailure(Call<ResponseInfo> call, Throwable t) {

                loginActivity.loginFailed();

            }
        });

    }
}

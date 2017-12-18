package com.itheima.takeout.dagger.module.activity;

import com.itheima.takeout.LoginActivity;
import com.itheima.takeout.presenter.LoginActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @Copyright (C), 2017
 * @FileName
 * @Author yang.xu
 * @email xuyangme@126.com
 * @Version
 * @Date 2017/11/25
 * @Description:
 */
@Module
public class LoginActivityModule {

    private LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    LoginActivityPresenter providerLoginActivityPresenter(){

        return new LoginActivityPresenter(loginActivity);
    }

}

package com.itheima.takeout.dagger.componet.activity;

import com.itheima.takeout.LoginActivity;
import com.itheima.takeout.dagger.module.activity.LoginActivityModule;

import dagger.Component;

/**
 * @Copyright (C), 2017
 * @FileName
 * @Author yang.xu
 * @email xuyangme@126.com
 * @Version
 * @Date 2017/11/25
 * @Description:
 */

@Component(modules = LoginActivityModule.class)
public interface LoginActivityComponet {

    void in(LoginActivity loginActivity);

}

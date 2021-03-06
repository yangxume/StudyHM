package com.itheima.takeout.model.net;


import com.itheima.takeout.model.Constant;
import com.itheima.takeout.model.ResponseInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static android.R.attr.password;


/**
 * @Copyright (C), 2017
 * @FileName
 * @Author yang.xu
 * @email xuyangme@126.com
 * @Version
 * @Date 2017/11/26
 * @Description:
 */

public interface ResponseInfoApi {

    @GET("TakeoutService/login")
    Call<ResponseInfo> login(@Query("username") String username, @Query("password") String password);

}

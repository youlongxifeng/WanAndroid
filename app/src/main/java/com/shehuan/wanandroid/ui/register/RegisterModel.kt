package com.shehuan.wanandroid.ui.register

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.RegisterBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:23
 * @description:  （添加一句描述）
 */

class RegisterModel:RegisterContract.Model {
    override fun register(username: String, password: String, repassword: String): Observable<BaseResponse<RegisterBean>> {
        val params = hashMapOf<String, String>()
        params["username"] = username
        params["password"] = password
        params["repassword"] = repassword
        return RetrofitManager.create(WanAndroidApis::class.java).register(params)
    }
}
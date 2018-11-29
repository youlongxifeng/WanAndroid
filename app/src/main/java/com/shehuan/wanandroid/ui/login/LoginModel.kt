package com.shehuan.wanandroid.ui.login

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.LoginBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:11
 * @description:  （添加一句描述）
 */
class LoginModel:LoginContract.Model{
    override fun login(username: String, password: String): Observable<BaseResponse<LoginBean>> {
        val params = hashMapOf<String, String>()
        params["username"] = username
        params["password"] = password
        return  RetrofitManager.create(WanAndroidApis::class.java).login(params)
    }
}
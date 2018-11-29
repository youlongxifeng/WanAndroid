package com.shehuan.wanandroid.ui.main

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 14:46
 * @description:  （添加一句描述）
 */
class MainModel():MainContract.Model{
    override fun logout(): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).logout()
    }
}
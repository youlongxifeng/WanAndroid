package com.shehuan.wanandroid.ui.website

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.FriendBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:28
 * @description:  （添加一句描述）
 */
class HotWebsiteModel:HotWebsiteContract.Model {
    override fun friend(): Observable<BaseResponse<List<FriendBean>>> {
    return RetrofitManager.create(WanAndroidApis::class.java).friend()
    }
}
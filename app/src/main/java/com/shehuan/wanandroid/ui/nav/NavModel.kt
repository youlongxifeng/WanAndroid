package com.shehuan.wanandroid.ui.nav

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.navi.NaviBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:14
 * @description:  （添加一句描述）
 */
class NavModel:NavContract.Model{
    override fun nav(): Observable<BaseResponse<List<NaviBean>>> {
    return RetrofitManager.create(WanAndroidApis::class.java).nav()
    }
}
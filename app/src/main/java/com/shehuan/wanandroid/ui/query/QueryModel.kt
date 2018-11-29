package com.shehuan.wanandroid.ui.query

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.HotKeyBean
import com.shehuan.wanandroid.bean.query.QueryBean
import com.shehuan.wanandroid.ui.query.QueryContract
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:19
 * @description:  （添加一句描述）
 */
class QueryModel:QueryContract.Model {
    override fun hotKey(): Observable<BaseResponse<List<HotKeyBean>>> {
        return RetrofitManager.create(WanAndroidApis::class.java).hotKey()
    }

    override fun query(pageNum: Int, k: String): Observable<BaseResponse<QueryBean>> {
        return RetrofitManager.create(WanAndroidApis::class.java).query(pageNum,k)
    }
}
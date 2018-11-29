package com.shehuan.wanandroid.ui.tree.treeDetail

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.treeDetail.TreeDetailBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:41
 * @description:  （添加一句描述）
 */
class TreeDetailModel:TreeDetailContract.Model {
    override fun treeDetail(pageNum: Int, cid: Int): Observable<BaseResponse<TreeDetailBean>> {
        return RetrofitManager.create(WanAndroidApis::class.java).treeDetail(pageNum,cid)
    }

    override fun collect(id: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).collectArticle(id)
    }

    override fun uncollect(id: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).uncollectArticle(id)
    }
}
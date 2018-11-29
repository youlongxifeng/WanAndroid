package com.shehuan.wanandroid.ui.collection

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.article.ArticleBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 15:55
 * @description:  （添加一句描述）
 */
class MyCollectionModel : MyCollectionContract.Model {
    override fun getCollectionList(id: Int): Observable<BaseResponse<ArticleBean>> {
        return RetrofitManager.create(WanAndroidApis::class.java).collectArticleList(id)
    }


    override fun cancelCollection(id: Int, originId: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).cancelMyCollection(id, originId)
    }
}
package com.shehuan.wanandroid.ui.collection

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.article.ArticleBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 15:52
 * @description:  （添加一句描述）
 */
class CollectModel:CollectContract.Model{
    override fun collect(id: Int): Observable<BaseResponse<String>> {
       return RetrofitManager.create(WanAndroidApis::class.java).collectArticle(id)
    }

    override fun uncollect(id: Int): Observable<BaseResponse<String>> {
        return  RetrofitManager.create(WanAndroidApis::class.java).uncollectArticle(id);
    }
}
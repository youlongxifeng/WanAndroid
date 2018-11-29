package com.shehuan.wanandroid.ui.home

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.BannerBean
import com.shehuan.wanandroid.bean.article.ArticleBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:05
 * @description:  （添加一句描述）
 */
class HomePresenterModel:HomeContract.Model{
    override fun banner() :Observable<BaseResponse<List<BannerBean>>>{
        return  RetrofitManager.create(WanAndroidApis::class.java).banner();
    }

    override fun articleList(pageNum: Int):Observable<BaseResponse<ArticleBean>> {
        return  RetrofitManager.create(WanAndroidApis::class.java).articleList(pageNum)
    }

    override fun collect(id: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).collectArticle(id)
    }

    override fun uncollect(id: Int): Observable<BaseResponse<String>> {
        return  RetrofitManager.create(WanAndroidApis::class.java).uncollectArticle(id)
    }
}
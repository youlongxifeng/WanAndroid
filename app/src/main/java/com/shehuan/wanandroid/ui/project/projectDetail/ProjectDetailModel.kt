package com.shehuan.wanandroid.ui.project.projectDetail

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:34
 * @description:  （添加一句描述）
 */
class ProjectDetailModel:ProjectDetailContract.Model {
    override fun uncollectArticle(id: Int): Observable<BaseResponse<String>> {
        return  RetrofitManager.create(WanAndroidApis::class.java).uncollectArticle(id)
    }

    override fun collectArticle(id: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).collectArticle(id)
    }
}
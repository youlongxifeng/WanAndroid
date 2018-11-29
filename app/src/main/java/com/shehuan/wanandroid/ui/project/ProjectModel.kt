package com.shehuan.wanandroid.ui.project

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.ProjectCategoryBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:16
 * @description:  （添加一句描述）
 */
class ProjectModel:ProjectContract.Model{
    override fun projectCategory(): Observable<BaseResponse<List<ProjectCategoryBean>>> {
    return RetrofitManager.create(WanAndroidApis::class.java).projectCategory()
    }
}
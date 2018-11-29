package com.shehuan.wanandroid.ui.project

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.ProjectCategoryBean
import io.reactivex.Observable

interface ProjectContract {
    interface View : BaseView {
        fun onProjectCategorySuccess(data: List<ProjectCategoryBean>)
        fun onProjectCategoryError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun projectCategory(): Observable<BaseResponse<List<ProjectCategoryBean>>>
    }
    interface Presenter {
        fun getProjectCategory()
    }
}
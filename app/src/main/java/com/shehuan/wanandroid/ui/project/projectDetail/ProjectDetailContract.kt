package com.shehuan.wanandroid.ui.project.projectDetail

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.ChapterBean
import com.shehuan.wanandroid.bean.project.ProjectBean
import com.shehuan.wanandroid.ui.collection.CollectContract
import io.reactivex.Observable
import retrofit2.http.Path

interface ProjectDetailContract {
    interface View : BaseView, CollectContract.View {
        fun onNewProjectListSuccess(data: ProjectBean)
        fun onNewProjectListError(e: ResponseException)

        fun onProjectDetailSuccess(data: ProjectBean)
        fun onProjectDetailError(e: ResponseException)
    }
    interface Model :BaseModel {
        fun uncollectArticle( id: Int): Observable<BaseResponse<String>>
        fun collectArticle( id: Int): Observable<BaseResponse<String>>
    }
    interface Presenter : CollectContract.Presenter {
        fun getNewProjectList(pageNum: Int)

        fun getProjectDetail(pageNum: Int, cid: Int)
    }
}
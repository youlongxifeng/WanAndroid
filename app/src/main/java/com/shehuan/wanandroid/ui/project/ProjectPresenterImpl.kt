package com.shehuan.wanandroid.ui.project

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.bean.ProjectCategoryBean

class ProjectPresenterImpl(view: ProjectContract.View) : BasePresenter<ProjectContract.View, ProjectContract.Model>(view), ProjectContract.Presenter {
    init {
        model = ProjectModel()
    }

    override fun getProjectCategory() {
        RequestManager.execute(this, model.projectCategory(),
                object : BaseObserver<List<ProjectCategoryBean>>() {
                    override fun onSuccess(data: List<ProjectCategoryBean>) {
                        view.onProjectCategorySuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onProjectCategoryError(e)
                    }
                })
    }
}
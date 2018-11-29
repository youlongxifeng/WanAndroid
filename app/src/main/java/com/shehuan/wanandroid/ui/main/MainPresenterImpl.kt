package com.shehuan.wanandroid.ui.main

import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.LoadingObserver
import com.shehuan.wanandroid.apis.WanAndroidApis
import java.util.*

class MainPresenterImpl(view: MainContract.View) : BasePresenter<MainContract.View,MainContract.Model>(view), MainContract.Presenter {
    //private val mainModel: MainContract.Model

    init {
        model = MainModel()
    }

    override fun logout() {
        RequestManager.execute(this, model.logout(),
                object : LoadingObserver<String>(context) {
                    override fun onSuccess(data: String) {
                        view.onLogoutSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onLogoutError(e)
                    }
                })
    }
}
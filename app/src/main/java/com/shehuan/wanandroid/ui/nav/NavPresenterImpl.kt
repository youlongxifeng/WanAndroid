package com.shehuan.wanandroid.ui.nav

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.bean.navi.NaviBean

class NavPresenterImpl(view: NavContract.View) : BasePresenter<NavContract.View,NavContract.Model>(view), NavContract.Presenter {
    init {
        model=NavModel()
    }
    override fun nav() {
        RequestManager.execute(this, model.nav(),
                object : BaseObserver<List<NaviBean>>() {
                    override fun onSuccess(data: List<NaviBean>) {
                        view.onNavSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onNavError(e)
                    }
                })
    }
}
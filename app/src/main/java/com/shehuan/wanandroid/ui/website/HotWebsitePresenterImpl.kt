package com.shehuan.wanandroid.ui.website

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.bean.FriendBean


class HotWebsitePresenterImpl(view: HotWebsiteContract.View) : BasePresenter<HotWebsiteContract.View,HotWebsiteContract.Model>(view), HotWebsiteContract.Presenter {
    init {
        model=HotWebsiteModel()
    }
    override fun getFriendData() {
        RequestManager.execute(this, model.friend(),
                object : BaseObserver<List<FriendBean>>() {
                    override fun onSuccess(data: List<FriendBean>) {
                        view.onFriedSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onFriendError(e)
                    }
                })
    }
}
package com.shehuan.wanandroid.ui.query

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.base.net.observer.LoadingObserver
import com.shehuan.wanandroid.bean.HotKeyBean
import com.shehuan.wanandroid.bean.query.QueryBean

class QueryPresenterImpl(view: QueryContract.View) : BasePresenter<QueryContract.View,QueryContract.Model>(view), QueryContract.Presenter {
    init {
        model=QueryModel()
    }

    override fun query(pageNum: Int, k: String, showLoading: Boolean) {
        RequestManager.execute(this, model.query(pageNum, k),
                object : LoadingObserver<QueryBean>(context, showLoading) {
                    override fun onSuccess(data: QueryBean) {
                        view.onQuerySuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onQueryError(e)
                    }
                })
    }

    override fun getHotKey() {
        RequestManager.execute(this, model.hotKey(),
                object : BaseObserver<List<HotKeyBean>>() {
                    override fun onSuccess(data: List<HotKeyBean>) {
                        view.onHotKeySuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onHotKeyError(e)
                    }
                })
    }

}
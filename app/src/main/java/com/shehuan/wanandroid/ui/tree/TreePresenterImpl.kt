package com.shehuan.wanandroid.ui.tree

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.bean.tree.TreeBean

class TreePresenterImpl(view: TreeContract.View) : BasePresenter<TreeContract.View,TreeContract.Model>(view), TreeContract.Presenter {

   init {
       model=TreeModel()
   }
    override fun getTree() {
        RequestManager.execute(this, model.tree(),
                object : BaseObserver<List<TreeBean>>() {
                    override fun onSuccess(data: List<TreeBean>) {
                        view.onTreeSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onTreeError(e)
                    }
                })
    }
}
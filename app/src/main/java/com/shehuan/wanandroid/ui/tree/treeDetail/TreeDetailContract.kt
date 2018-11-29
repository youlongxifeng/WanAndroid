package com.shehuan.wanandroid.ui.tree.treeDetail

import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.treeDetail.TreeDetailBean
import com.shehuan.wanandroid.ui.collection.CollectContract
import io.reactivex.Observable

interface TreeDetailContract {
    interface View : BaseView, CollectContract.View {
        fun onTreeDetailSuccess(data: TreeDetailBean)
        fun onTreeDetailError(e: ResponseException)
    }

    interface Model : CollectContract.Model {
        fun     treeDetail(  pageNum: Int,  cid: Int): Observable<BaseResponse<TreeDetailBean>>
    }

    interface Presenter : CollectContract.Presenter {
        fun getTreeDetail(pageNum: Int, cid: Int)
    }
}
package com.shehuan.wanandroid.ui.tree

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.tree.TreeBean
import io.reactivex.Observable

interface TreeContract {
    interface View : BaseView {
        fun onTreeSuccess(data: List<TreeBean>)
        fun onTreeError(e: ResponseException)
    }
    interface Model:BaseModel {
        fun tree(): Observable<BaseResponse<List<TreeBean>>>
    }
    interface Presenter {
        fun getTree()
    }
}
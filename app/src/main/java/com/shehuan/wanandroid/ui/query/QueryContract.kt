package com.shehuan.wanandroid.ui.query

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.HotKeyBean
import com.shehuan.wanandroid.bean.query.QueryBean
import io.reactivex.Observable

interface QueryContract {
    interface View : BaseView {
        fun onQuerySuccess(data: QueryBean)
        fun onQueryError(e: ResponseException)

        fun onHotKeySuccess(data: List<HotKeyBean>)
        fun onHotKeyError(e: ResponseException)
    }

    interface Model : BaseModel {
        fun query(pageNum: Int, k: String): Observable<BaseResponse<QueryBean>>

        fun hotKey(): Observable<BaseResponse<List<HotKeyBean>>>
    }

    interface Presenter {
        fun query(pageNum: Int, k: String, showLoading: Boolean)

        fun getHotKey()
    }
}
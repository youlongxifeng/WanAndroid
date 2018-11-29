package com.shehuan.wanandroid.ui.collection

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.article.ArticleBean
import io.reactivex.Observable

interface CollectContract {
    interface View : BaseView {
        fun onCollectSuccess(data: String)
        fun onCollectError(e: ResponseException)

        fun onUncollectSuccess(data: String)
        fun onUncollectError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun collect(id: Int): Observable<BaseResponse<String>>

        fun uncollect(id: Int): Observable<BaseResponse<String>>
    }
    interface Presenter {
        fun collect(id: Int)

        fun uncollect(id: Int)
    }
}
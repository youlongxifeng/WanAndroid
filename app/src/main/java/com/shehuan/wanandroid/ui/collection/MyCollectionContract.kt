package com.shehuan.wanandroid.ui.collection

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.article.ArticleBean
import io.reactivex.Observable

interface MyCollectionContract {
    interface View : BaseView {
        fun onCollectionListSuccess(data: ArticleBean)
        fun onCollectionListError(e: ResponseException)

        fun onCancelCollectionSuccess(data: String)
        fun onCancelCollectionError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun cancelCollection(id: Int, originId: Int): Observable<BaseResponse<String>>

        fun getCollectionList(id: Int): Observable<BaseResponse<ArticleBean>>
    }


    interface Presenter {
        fun getCollectionList(pageNum: Int)

        fun cancelCollection(id: Int, originId: Int)
    }
}
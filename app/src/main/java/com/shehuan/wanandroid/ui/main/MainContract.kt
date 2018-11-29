package com.shehuan.wanandroid.ui.main

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import io.reactivex.Observable

interface MainContract {
    interface View : BaseView {
        fun onLogoutSuccess(data: String)
        fun onLogoutError(e: ResponseException)
    }

    interface Model : BaseModel {
        fun logout(): Observable<BaseResponse<String>>
    }

    interface Presenter {
        fun logout()
    }
}
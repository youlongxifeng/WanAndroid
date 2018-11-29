package com.shehuan.wanandroid.ui.login

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.LoginBean
import io.reactivex.Observable

interface LoginContract {
    interface View : BaseView {
        fun onLoginSuccess(data: LoginBean)
        fun onLoginError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun login(username: String, password: String): Observable<BaseResponse<LoginBean>>
    }
    interface Presenter {
        fun login(username: String, password: String)
    }
}
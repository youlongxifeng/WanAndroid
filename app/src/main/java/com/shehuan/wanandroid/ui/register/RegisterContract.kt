package com.shehuan.wanandroid.ui.register

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.LoginBean
import com.shehuan.wanandroid.bean.RegisterBean
import io.reactivex.Observable

interface RegisterContract {
    interface View : BaseView {
        fun onRegisterSuccess(data: RegisterBean)
        fun onRegisterError(e: ResponseException)
    }
    interface Model: BaseModel {
         fun register(username: String, password: String, repassword: String): Observable<BaseResponse<RegisterBean>>
    }
    interface Presenter {
        fun register(username: String, password: String, repassword: String)
    }
}
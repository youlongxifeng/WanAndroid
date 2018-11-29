package com.shehuan.wanandroid.ui.register

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.LoadingObserver
import com.shehuan.wanandroid.bean.RegisterBean

class RegisterPresenterImpl(view: RegisterContract.View) : BasePresenter<RegisterContract.View,RegisterContract.Model>(view), RegisterContract.Presenter {
   init {
       model=RegisterModel()
   }

    override fun register(username: String, password: String, repassword: String) {
        val params = hashMapOf<String, String>()
        params["username"] = username
        params["password"] = password
        params["repassword"] = repassword
        RequestManager.execute(this, model.register(username,password,repassword),
                object : LoadingObserver<RegisterBean>(context) {
                    override fun onSuccess(data: RegisterBean) {
                        view.onRegisterSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onRegisterError(e)
                    }
                })
    }

}
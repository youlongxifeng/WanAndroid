package com.shehuan.wanandroid.ui.nav

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.navi.NaviBean
import io.reactivex.Observable

interface NavContract {
    interface View : BaseView {
        fun onNavSuccess(data: List<NaviBean>)
        fun onNavError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun nav(): Observable<BaseResponse<List<NaviBean>>>
    }
    interface Presenter {
        fun nav()
    }
}
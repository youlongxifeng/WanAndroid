package com.shehuan.wanandroid.ui.website

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.FriendBean
import io.reactivex.Observable

interface HotWebsiteContract {
    interface View : BaseView {
        fun onFriedSuccess(data: List<FriendBean>)
        fun onFriendError(e: ResponseException)
    }

    interface Model: BaseModel {
        fun friend(): Observable<BaseResponse<List<FriendBean>>>
    }
    interface Presenter {
        fun getFriendData()
    }
}
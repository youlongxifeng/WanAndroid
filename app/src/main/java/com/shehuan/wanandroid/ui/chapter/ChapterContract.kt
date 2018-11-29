package com.shehuan.wanandroid.ui.chapter

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.ChapterBean
import io.reactivex.Observable

interface ChapterContract {
    interface View : BaseView {
        fun onChapterSuccess(data: List<ChapterBean>)
        fun onChapterError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun getChapter(): Observable<BaseResponse<List<ChapterBean>>>
    }
    interface Presenter {
        fun getChapter()
    }
}
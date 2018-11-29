package com.shehuan.wanandroid.ui.chapter

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.bean.ChapterBean

class ChapterPresenterImpl(view: ChapterContract.View) : BasePresenter<ChapterContract.View,ChapterContract.Model>(view), ChapterContract.Presenter {
    init {
        model=ChapterModel()
    }
    override fun getChapter() {
        RequestManager.execute(this,model.getChapter(),
                object : BaseObserver<List<ChapterBean>>() {
                    override fun onSuccess(data: List<ChapterBean>) {
                        view.onChapterSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onChapterError(e)
                    }
                })
    }
}
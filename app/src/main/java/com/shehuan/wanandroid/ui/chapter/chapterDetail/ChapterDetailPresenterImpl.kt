package com.shehuan.wanandroid.ui.chapter.chapterDetail

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BasePresenter
import com.shehuan.wanandroid.base.net.RequestManager
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.base.net.observer.BaseObserver
import com.shehuan.wanandroid.base.net.observer.LoadingObserver
import com.shehuan.wanandroid.bean.chapter.ChapterArticleBean

class ChapterDetailPresenterImpl(view: ChapterDetailContract.View) : BasePresenter<ChapterDetailContract.View,ChapterDetailContract.Model>(view), ChapterDetailContract.Presenter {
    init {
        model = ChapterDetailModel()
    }

    override fun uncollect(id: Int) {
        RequestManager.execute(this, model.uncollectArticle(id),
                object : LoadingObserver<String>(context) {
                    override fun onSuccess(data: String) {
                        view.onUncollectSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onUncollectError(e)
                    }
                })
    }

    override fun collect(id: Int) {
        RequestManager.execute(this, model.collectArticle(id),
                object : LoadingObserver<String>(context) {
                    override fun onSuccess(data: String) {
                        view.onCollectSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onCollectError(e)
                    }
                })
    }

    override fun getChapterArticleList(chapterId: Int, pageNum: Int) {
        RequestManager.execute(this, model.chapterArticleList(chapterId, pageNum),
                object : BaseObserver<ChapterArticleBean>() {
                    override fun onSuccess(data: ChapterArticleBean) {
                        view.onChapterArticleListSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onChapterArticleListError(e)
                    }
                })
    }

    override fun queryChapterArticle(chapterId: Int, pageNum: Int, k: String) {
        RequestManager.execute(this, model.queryChapterArticle(chapterId, pageNum, k),
                object : BaseObserver<ChapterArticleBean>() {
                    override fun onSuccess(data: ChapterArticleBean) {
                        view.onQueryChapterArticleListSuccess(data)
                    }

                    override fun onError(e: ResponseException) {
                        view.onQueryChapterArticleListError(e)
                    }
                })
    }
}
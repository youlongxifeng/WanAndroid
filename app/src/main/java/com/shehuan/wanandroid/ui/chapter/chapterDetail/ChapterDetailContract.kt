package com.shehuan.wanandroid.ui.chapter.chapterDetail

import com.shehuan.wanandroid.base.BaseModel
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.BaseView
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.bean.chapter.ChapterArticleBean
import com.shehuan.wanandroid.ui.collection.CollectContract
import io.reactivex.Observable
import retrofit2.http.Path

interface ChapterDetailContract {
    interface View : BaseView, CollectContract.View {
        fun onChapterArticleListSuccess(data: ChapterArticleBean)
        fun onChapterArticleListError(e: ResponseException)

        fun onQueryChapterArticleListSuccess(data: ChapterArticleBean)
        fun onQueryChapterArticleListError(e: ResponseException)
    }
    interface Model: BaseModel {
        fun getChapterArticleList(chapterId: Int, pageNum: Int):Observable<BaseResponse<ChapterArticleBean>>

        fun queryChapterArticle(chapterId: Int, pageNum: Int, k: String): Observable<BaseResponse<ChapterArticleBean>>
        fun uncollectArticle(  id: Int): Observable<BaseResponse<String>>
        fun collectArticle(  id: Int): Observable<BaseResponse<String>>
        fun chapterArticleList(chapterId: Int, pageNum: Int): Observable<BaseResponse<ChapterArticleBean>>

    }
    interface Presenter : CollectContract.Presenter {
        fun getChapterArticleList(chapterId: Int, pageNum: Int)

        fun queryChapterArticle(chapterId: Int, pageNum: Int, k: String)
    }
}
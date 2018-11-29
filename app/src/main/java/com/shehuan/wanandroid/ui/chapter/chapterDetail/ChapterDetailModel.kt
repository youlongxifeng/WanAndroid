package com.shehuan.wanandroid.ui.chapter.chapterDetail

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.chapter.ChapterArticleBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 15:36
 * @description:  （添加一句描述）
 */
class ChapterDetailModel : ChapterDetailContract.Model {
    override fun chapterArticleList(chapterId: Int, pageNum: Int): Observable<BaseResponse<ChapterArticleBean>> {
        return RetrofitManager.create(WanAndroidApis::class.java).chapterArticleList(chapterId,pageNum)
    }

    override fun collectArticle(id: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).collectArticle(id)
    }

    override fun uncollectArticle(id: Int): Observable<BaseResponse<String>> {
        return RetrofitManager.create(WanAndroidApis::class.java).uncollectArticle(id)
    }

    override fun queryChapterArticle(chapterId: Int, pageNum: Int, k: String): Observable<BaseResponse<ChapterArticleBean>> {
        return RetrofitManager.create(WanAndroidApis::class.java).queryChapterArticle(chapterId, pageNum,k)
    }

    override fun getChapterArticleList(chapterId: Int, pageNum: Int): Observable<BaseResponse<ChapterArticleBean>> {
        return RetrofitManager.create(WanAndroidApis::class.java).chapterArticleList(chapterId, pageNum)
    }


}
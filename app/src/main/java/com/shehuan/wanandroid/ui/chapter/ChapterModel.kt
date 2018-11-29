package com.shehuan.wanandroid.ui.chapter

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.ChapterBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 15:48
 * @description:  （添加一句描述）
 */
class ChapterModel:ChapterContract.Model{
    override fun getChapter(): Observable<BaseResponse<List<ChapterBean>>> {
        return RetrofitManager.create(WanAndroidApis::class.java).chapter()
    }
}
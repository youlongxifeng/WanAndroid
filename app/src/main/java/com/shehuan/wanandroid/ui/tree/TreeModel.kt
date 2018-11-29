package com.shehuan.wanandroid.ui.tree

import com.shehuan.wanandroid.apis.WanAndroidApis
import com.shehuan.wanandroid.base.BaseResponse
import com.shehuan.wanandroid.base.net.RetrofitManager
import com.shehuan.wanandroid.bean.tree.TreeBean
import io.reactivex.Observable

/**
 * @Author:  xiezhenggen
 * @Time:  2018 2018/11/29 16:26
 * @description:  （添加一句描述）
 */
class TreeModel:TreeContract.Model{
    override fun tree(): Observable<BaseResponse<List<TreeBean>>> {
    return RetrofitManager.create(WanAndroidApis::class.java).tree()
    }
}
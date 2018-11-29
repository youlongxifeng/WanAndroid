package com.shehuan.wanandroid.base.net.observer

import android.content.Context
import com.shehuan.wanandroid.App
import com.shehuan.wanandroid.base.net.exception.ResponseException
import com.shehuan.wanandroid.utils.ToastUtil
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

abstract class BaseObserver<E>(private val showErrorTip: Boolean = true) : Observer<E> {
    private val wrContext: WeakReference<Context> = WeakReference(App.getApp())
    //Kotlin中有两种延迟初始化的方式。一种是lateinit var，一种是by lazy。 lateinit var只能用来修饰类属性，不能用来修饰局部变量
    //lateinit var只是让编译期忽略对属性未初始化的检查，后续在哪里以及何时初始化还需要开发者自己决定。
    //by lazy真正做到了声明的同时也指定了延迟初始化时的行为，在属性被第一次被使用的时候能自动初始化。但这些功能是要为此付出一丢丢代价的。
    private lateinit var disposable: Disposable

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(data: E) {
        onSuccess(data)
    }

    override fun onError(e: Throwable) {
        val responseException: ResponseException = e as ResponseException
        if (showErrorTip) {
            ToastUtil.showToast(wrContext.get(), responseException.getErrorMessage())
        }
        onError(responseException)
    }

    override fun onComplete() {

    }

    fun getDisposable() = disposable

    abstract fun onSuccess(data: E)

    abstract fun onError(e: ResponseException)
}
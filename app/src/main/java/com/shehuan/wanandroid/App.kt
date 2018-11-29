package com.shehuan.wanandroid

import android.app.Application
import org.litepal.LitePal

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        LitePal.initialize(this)
    }
//companion object 修饰为伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
    companion object {
        private lateinit var instance: App
        fun getApp(): App {
            return instance
        }
    }
}
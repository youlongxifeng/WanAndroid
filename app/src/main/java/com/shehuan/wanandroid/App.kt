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
    //lateinit var只能用来修饰类属性，不能用来修饰局部变量，并且只能用来修饰对象，不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)。
        private lateinit var instance: App
        fun getApp(): App {
            return instance
        }
    }
}
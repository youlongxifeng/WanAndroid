package com.shehuan.wanandroid.utils

import android.content.Context

class CommonUtil {
    /**
     * 修饰为伴生对象,伴生对象在类中只能存在一个，类似于java中的静态方法 Java 中使用类访问静态成员，静态方法。
     */
    companion object {
        fun dp2px(context: Context, dipValue: Int): Int {
            val scale = context.resources.displayMetrics.density
            return (dipValue * scale + 0.5f).toInt()
        }
    }
}
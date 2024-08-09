package com.jm.logutillib

import android.app.Application
import com.jm.logutil.LogUtil

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        LogUtil.init(applicationContext, tag = "JM")

        LogUtil.d("onCreate")
    }
}
package cn.mycommons.android.easy_captcha_android.app

import android.app.Application
import android.content.Context

/**
 * AppContext <br/>
 * Created by xiaqiulei on 2019-11-30.
 */

class AppContext : Application() {

    companion object {

        private lateinit var instance: AppContext

        fun getApp(): AppContext = instance
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        instance = this
    }
}
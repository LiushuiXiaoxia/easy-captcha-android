package cn.mycommons.android.easy_captcha_android.core

import cn.mycommons.android.easy_captcha_android.core.http.retrofitApi
import cn.mycommons.android.easy_captcha_android.core.retrofit.ICaptchaApi

/**
 * Apis <br/>
 * Created by xiaqiulei on 2019-11-30.
 */

object Apis {

    val captchaApi: ICaptchaApi by lazy { retrofitApi().create(ICaptchaApi::class.java) }
}

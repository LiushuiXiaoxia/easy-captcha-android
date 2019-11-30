package cn.mycommons.android.easy_captcha_android.core.bean.captcha

import com.google.gson.annotations.SerializedName

/**
 * CaptchaCheck <br/>
 * Created by xiaqiulei on 2019-11-30.
 */

class CaptchaCheckReq {

    @SerializedName("userId")
    var userId: String? = null

    @SerializedName("channel")
    var channel: String? = null

    @SerializedName("captchaId")
    var captchaId: String? = null

    @SerializedName("captchaText")
    var captchaText: String? = null
}
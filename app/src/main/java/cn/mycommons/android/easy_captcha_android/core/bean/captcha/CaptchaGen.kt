package cn.mycommons.android.easy_captcha_android.core.bean.captcha

import com.google.gson.annotations.SerializedName

/**
 * CaptchaGenReq <br></br>
 * Created by xiaqiulei on 2019-11-30.
 */
class CaptchaGenReq {

    @SerializedName("userId")
    var userId: String? = null

    @SerializedName("channel")
    var channel: String? = null
}

class CaptchaGenData {

    @SerializedName("captchaId")
    var captchaId: String? = null

    @SerializedName("imageBase64Header")
    var imageBase64Header: String? = null

    @SerializedName("imageBase64")
    var imageBase64: String? = null
}
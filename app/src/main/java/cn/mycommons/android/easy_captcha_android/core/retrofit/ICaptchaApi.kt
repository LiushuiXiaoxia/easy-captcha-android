package cn.mycommons.android.easy_captcha_android.core.retrofit

import cn.mycommons.android.easy_captcha_android.core.bean.BaseResp
import cn.mycommons.android.easy_captcha_android.core.bean.captcha.CaptchaCheckReq
import cn.mycommons.android.easy_captcha_android.core.bean.captcha.CaptchaGenData
import cn.mycommons.android.easy_captcha_android.core.bean.captcha.CaptchaGenReq
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * ICaptchaApi <br/>
 * Created by xiaqiulei on 2019-11-30.
 */
interface ICaptchaApi {

    @POST("/captcha/gen")
    fun gen(@Body req: CaptchaGenReq): Call<BaseResp<CaptchaGenData>>

    @POST("/captcha/check")
    fun check(@Body req: CaptchaCheckReq): Call<BaseResp<Boolean>>
}
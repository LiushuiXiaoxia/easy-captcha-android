package cn.mycommons.android.easy_captcha_android.core.bean

/**
 * BaseResp <br></br>
 * Created by xiaqiulei on 2019-11-30.
 */
class BaseResp<T> {

    var code: Int = 0

    var msg: String? = null

    var data: T? = null
}
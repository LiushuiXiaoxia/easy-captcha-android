package cn.mycommons.android.easy_captcha_android

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cn.mycommons.android.easy_captcha_android.core.Apis
import cn.mycommons.android.easy_captcha_android.core.bean.BaseResp
import cn.mycommons.android.easy_captcha_android.core.bean.captcha.CaptchaCheckReq
import cn.mycommons.android.easy_captcha_android.core.bean.captcha.CaptchaGenData
import cn.mycommons.android.easy_captcha_android.core.bean.captcha.CaptchaGenReq
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var captchaGenData: CaptchaGenData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivCode.setOnClickListener {
            loadImageCode()
        }
        btnCheck.setOnClickListener {
            check()
        }

        loadImageCode()
    }

    private fun loadImageCode() {
        val req = CaptchaGenReq()
        req.channel = "account_pwd_change"
        req.userId = "12345"

        Apis.captchaApi.gen(req).enqueue(object : Callback<BaseResp<CaptchaGenData>> {

            override fun onResponse(call: Call<BaseResp<CaptchaGenData>>,
                                    response: Response<BaseResp<CaptchaGenData>>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.data?.let {
                        captchaGenData = it

                        val bytes = Base64.decode(it.imageBase64, Base64.DEFAULT)
                        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                        ivCode.setImageBitmap(bitmap)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResp<CaptchaGenData>>, t: Throwable) {
            }
        })
    }

    private fun check() {
        val code = edtCode.text.toString()
        if (code.isNotEmpty()) {
            captchaGenData?.let {
                val req = CaptchaCheckReq().apply {
                    captchaId = it.captchaId
                    captchaText = code
                    channel = "account_pwd_change"
                    userId = "12345"
                }

                Apis.captchaApi.check(req).enqueue(object : Callback<BaseResp<Boolean>> {

                    override fun onResponse(call: Call<BaseResp<Boolean>>,
                                            response: Response<BaseResp<Boolean>>) {
                        if (response.isSuccessful) {
                            response.body()?.data?.let {
                                val msg = if (it) "check success " else "check fail"
                                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<BaseResp<Boolean>>, t: Throwable) {
                    }
                })
            }
        } else {
            Toast.makeText(this, "请输入验证码", Toast.LENGTH_LONG).show()
        }
    }
}
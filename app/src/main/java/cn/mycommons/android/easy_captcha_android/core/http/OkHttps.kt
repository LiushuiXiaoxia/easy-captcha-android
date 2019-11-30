package cn.mycommons.android.easy_captcha_android.core.http

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * OkHttps <br/>
 * Created by xiaqiulei on 2019-11-30.
 */


const val HOST = "http://192.168.237.23:8001"

fun client(): OkHttpClient {

    val logging = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Log.i("OkHttp", message)
        }
    })
    logging.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}

fun retrofitApi(): Retrofit {
    val client = client()
    return Retrofit.Builder()
        .baseUrl(HOST)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

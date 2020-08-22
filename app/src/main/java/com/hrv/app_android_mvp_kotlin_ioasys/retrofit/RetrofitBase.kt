package com.hrv.app_android_mvp_kotlin_ioasys.retrofit

import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services.LoginService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitBase {
    private val URL_BASE = "https://empresas.ioasys.com.br/"

    // private var login: LoginService? = null
    var mRetrofit: Retrofit

    init{
        mRetrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            //.client(configuraClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun configuraClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    fun getLoginService(): LoginService {
        return mRetrofit.create(LoginService::class.java)
    }
    /*  fun getEmpresaService(): EmpresaService? {
          return login
      }*/
}
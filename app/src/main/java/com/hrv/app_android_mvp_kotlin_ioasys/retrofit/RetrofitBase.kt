package com.hrv.app_android_mvp_kotlin_ioasys.retrofit

import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services.EmpresaService
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services.LoginService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitBase {
    private val URL_BASE = "https://empresas.ioasys.com.br/"
    var mRetrofit: Retrofit

    init{
        mRetrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getLoginService(): LoginService {
        return mRetrofit.create(LoginService::class.java)
    }
    fun getEmpresaService(): EmpresaService {
        return mRetrofit.create(EmpresaService::class.java)
    }

}
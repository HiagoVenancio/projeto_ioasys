package com.hrv.app_android_mvp_kotlin_ioasys.retrofit

import com.hrv.app_android_mvp_kotlin_ioasys.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services.EmpresaService
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services.LoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitBase {
    private var mRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constantes.URL_BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getLoginService(): LoginService {
        return mRetrofit.create(LoginService::class.java)
    }

    fun getEmpresaService(): EmpresaService {
        return mRetrofit.create(EmpresaService::class.java)
    }

}
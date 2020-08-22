package com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services

import com.hrv.app_android_mvp_kotlin_ioasys.entities.response.EmpresaResposta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface EmpresaService : LoginService {

    @Headers("Content-Type: application/json")
    @GET("api/v1/enterprises/1")
    fun buscaTodos(
        @Header("access-token") accessToken: String,
        @Header("client") client: String,
        @Header("uid") uid: String
    ): Call<EmpresaResposta>
}
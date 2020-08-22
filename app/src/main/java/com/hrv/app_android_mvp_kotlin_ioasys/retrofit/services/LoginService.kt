package com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services

import com.hrv.app_android_mvp_kotlin_ioasys.entities.Empresas
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("api/v1/users/auth/sign_in")
    fun loginUsuario(@Body login: Login): Call<Empresas>
}
package com.hrv.app_android_mvp_kotlin_ioasys.retrofit.services

import com.hrv.app_android_mvp_kotlin_ioasys.entities.Empresas
import retrofit2.Call
import retrofit2.http.GET

interface EmpresaService : LoginService {

    @GET("")
    fun buscaTodos(): Call<Empresas>
}
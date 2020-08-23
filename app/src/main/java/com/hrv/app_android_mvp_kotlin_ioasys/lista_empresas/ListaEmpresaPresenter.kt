package com.hrv.app_android_mvp_kotlin_ioasys.lista_empresas

import android.content.Context
import com.hrv.app_android_mvp_kotlin_ioasys.entities.response.EmpresasResposta
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.RetrofitBase
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.SharedPreferencesConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaEmpresaPresenter(
    val context: Context,
    private val listaEmpresaView: IListaEmpresas.View
) : IListaEmpresas.Presenter {

    private val mRetrofitEmpresa = RetrofitBase().getEmpresaService()

    override fun pesquisarEmpresa(nomeEmpresa: String) {

        listaEmpresaView.iniciarPesquisaEmpresa()

        val callEmpresa = mRetrofitEmpresa.buscaPeloFiltro(
            SharedPreferencesConfig.recuperarEstado(context, Constantes.KEY_REQUEST_ACCESS_TOKEN),
            SharedPreferencesConfig.recuperarEstado(context, Constantes.KEY_REQUEST_CLIENT),
            SharedPreferencesConfig.recuperarEstado(context, Constantes.KEY_REQUEST_UID),
            1,
            nomeEmpresa
        )
        callEmpresa.enqueue(object : Callback<EmpresasResposta> {
            override fun onResponse(
                call: Call<EmpresasResposta>?,
                response: Response<EmpresasResposta>
            ) {
                if (response.body()!!.enterprise.isNotEmpty()) {
                    listaEmpresaView.trouxeEmpresaNaPesquisa()
                    listaEmpresaView.atualizarListaEmpresas(response.body()!!.enterprise)
                } else {
                    listaEmpresaView.naoAchouEmpresa()
                }
            }

            override fun onFailure(call: Call<EmpresasResposta>?, t: Throwable) {
                listaEmpresaView.erroAoTrazerEmpresa()
            }
        })
    }
}
package com.hrv.app_android_mvp_kotlin_ioasys.login

import android.content.Context
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.Constantes
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Login
import com.hrv.app_android_mvp_kotlin_ioasys.entities.response.LoginResposta
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.RetrofitBase
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.SharedPreferencesConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenter(val context: Context, private val loginView: ILogin.View) : ILogin.Presenter {

    val mUsuario: String = "testeapple@ioasys.com.br"
    val mSenha: String = "12341234"
    private val mRetrofitLogin = RetrofitBase().getLoginService()

    override fun validarDadosLogin(usuario: String, senha: String) {
        if (usuario.isEmpty() || senha.isEmpty()) {
            loginView.camposVazios()

        } else {
            loginView.iniciarLogin()

            val login = Login(usuario, senha)
            val callLogin = mRetrofitLogin.loginUsuario(login)
            callLogin.enqueue(object : Callback<LoginResposta> {
                override fun onResponse(
                    call: Call<LoginResposta>?,
                    response: Response<LoginResposta>
                ) {

                    if (response.isSuccessful) {
                        SharedPreferencesConfig.salvarEstado(
                            context, Constantes.KEY_REQUEST_ACCESS_TOKEN,
                            response.headers().get(Constantes.KEY_REQUEST_ACCESS_TOKEN).toString()
                        )

                        SharedPreferencesConfig.salvarEstado(
                            context, Constantes.KEY_REQUEST_CLIENT,
                            response.headers().get(Constantes.KEY_REQUEST_CLIENT).toString()
                        )

                        SharedPreferencesConfig.salvarEstado(
                            context, Constantes.KEY_REQUEST_UID,
                            response.headers().get(Constantes.KEY_REQUEST_UID).toString()
                        )

                        loginView.terminarLogin()
                        loginView.sucessoAoLogar()
                    } else {
                        loginView.dadosIncorretos()
                    }
                }

                override fun onFailure(call: Call<LoginResposta?>?, t: Throwable?) {
                    loginView.erroDeComunicacaoComServidor()
                }
            })
        }
    }
}
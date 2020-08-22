package com.hrv.app_android_mvp_kotlin_ioasys.login

import android.util.Log
import com.hrv.app_android_mvp_kotlin_ioasys.entities.response.EmpresaResposta
import com.hrv.app_android_mvp_kotlin_ioasys.entities.response.LoginResposta
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Login
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.RetrofitBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenter(private val loginView: ILogin.View) : ILogin.Presenter {

    val mUsuario: String = "testeapple@ioasys.com.br"
    val mSenha: String = "12341234"
    val mRetrofitLogin = RetrofitBase().getLoginService()
    val mRetrofitEmpresa = RetrofitBase().getEmpresaService()

    override fun validarDadosLogin(usuario: String, senha: String) {
        /*  if (usuario.isEmpty() || senha.isEmpty()) {
              loginView.camposVazios()

          }
          else {*/
        loginView.iniciarLogin()

        val login = Login(mUsuario, mSenha)
        val callLogin = mRetrofitLogin.loginUsuario(login)
        callLogin.enqueue(object : Callback<LoginResposta> {
            override fun onResponse(call: Call<LoginResposta>?, response: Response<LoginResposta>) {
                val invest =response.body()!!.investor
                Log.d("RESPOSTA RETROFIT", "RESPOSTA: ${invest.id} - ${invest.investor_name}")


                /*INICIO EMPRESA*/
         /*       val callEmpresa = mRetrofitEmpresa.buscaTodos(
                    response.headers().get("access-token").toString(),
                    response.headers().get("client").toString(),
                    response.headers().get("uid").toString()
                )
                callEmpresa.enqueue(object : Callback<EmpresaResposta> {
                    override fun onResponse(call: Call<EmpresaResposta>?, response: Response<EmpresaResposta>) {
                        val enterprise = response.body()!!.enterprise
                        Log.d("RESPOSTA RETROFIT", "NOME EMPRESA: ${enterprise!!.enterprise_name} - ${enterprise.city}")

                    }

                    override fun onFailure(call: Call<EmpresaResposta?>?, t: Throwable) {
                        Log.d("RESPOSTA ERRO", "RESPOSTA: ${t.message}")
                    }

                })*/
                /*FIM EMPRESA*/


                loginView.terminarLogin()
                loginView.sucessoAoLogar()
            }

            override fun onFailure(call: Call<LoginResposta?>?, t: Throwable?) {
                Log.d("RESPOSTA ERRO", "RESPOSTA: ${call.toString()}")
                loginView.dadosIncorretos()
            }

        })


    }
}


//}
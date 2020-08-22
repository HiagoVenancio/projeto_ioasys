package com.hrv.app_android_mvp_kotlin_ioasys.login

import android.util.Log
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Empresas
import com.hrv.app_android_mvp_kotlin_ioasys.entities.Login
import com.hrv.app_android_mvp_kotlin_ioasys.retrofit.RetrofitBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginPresenter(private val loginView: ILogin.View) : ILogin.Presenter {

    val mUsuario: String = "testeapple@ioasys.com.br"
    val mSenha: String = "12341234"
    val mRetrofit = RetrofitBase().getLoginService()

    override fun validarDadosLogin(usuario: String, senha: String) {
        /*  if (usuario.isEmpty() || senha.isEmpty()) {
              loginView.camposVazios()

          }
          else {*/
        loginView.iniciarLogin()
        val login = Login(mUsuario, mSenha)
        val call = mRetrofit.loginUsuario(login)
        call.enqueue(object : Callback<Empresas> {
            override fun onResponse(call: Call<Empresas>?, response: Response<Empresas>) {
                Log.d("RESPOSTA RETROFIT", "headers: ${response.headers()}")
                var invest =response.body()!!.investor
                Log.d("RESPOSTA RETROFIT", "RESPOSTA: ${invest.id} - ${invest.investor_name}")
                loginView.terminarLogin()
                loginView.sucessoAoLogar()
            }

            override fun onFailure(call: Call<Empresas?>?, t: Throwable?) {
                Log.d("RESPOSTA ERRO", "RESPOSTA: ${call.toString()}")
                loginView.dadosIncorretos()
            }

        })


    }
}


//}
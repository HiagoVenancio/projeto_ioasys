package com.hrv.app_android_mvp_kotlin_ioasys.login

interface ILogin {

    interface View{
        fun iniciarLogin()
        fun terminarLogin()
        fun camposVazios()
        fun dadosIncorretos()
        fun erroDeComunicacaoComServidor()
        fun sucessoAoLogar()

    }


    interface Presenter{
        fun validarDadosLogin(usuario:String, senha:String)
    }

}
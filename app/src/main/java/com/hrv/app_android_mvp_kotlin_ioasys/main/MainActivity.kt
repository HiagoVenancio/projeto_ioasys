package com.hrv.app_android_mvp_kotlin_ioasys.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hrv.app_android_mvp_kotlin_ioasys.R
import com.hrv.app_android_mvp_kotlin_ioasys.login.LoginActivity
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.SharedPreferencesConfig
import com.hrv.app_android_mvp_kotlin_ioasys.utilitarios.Util
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), IMain.View {

    private lateinit var presenter: IMain.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        btnLogout.setOnClickListener{
            presenter.logout()
        }
    }

    override fun sairDaAplicacao() {
        SharedPreferencesConfig.logout(this)
        val intent = Intent(this, LoginActivity::class.java)
        Util.limparActivitiesAnteriores(intent)
        startActivity(intent)
    }
}